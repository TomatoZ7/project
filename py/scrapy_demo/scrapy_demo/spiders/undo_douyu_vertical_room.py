import json
import scrapy
from ..items import DouyuAnchorItem


class DouyuVerticalRoomSpider(scrapy.Spider):
    name = 'douyu_vertical_room'
    allowed_domains = ['douyucdn.cn']
    start_urls = ['http://capi.douyucdn.cn/api/v1/getVerticalRoom?limit=20&offset=0']
    # custom_settings = {
    #     'ITEM_PIPELINES': {'scrapy_demo.pipelines.DouyuVerticalRoomPipeline': 400}
    # }
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
        'Chrome/96.0.4664.55 Safari/537.36',
        'Accept': 'text / html, application / xhtml + xml, application / xml',
    }

    def start_requests(self):
        for url in self.start_urls:
            yield scrapy.Request(url=url, headers=self.headers, callback=self.parse)

    def parse(self, response):
        # item = DouyuAnchorItem()

        data_list = json.loads(response.body)['data']
        print(data_list)
        # for data in data_list:
        #     item['nick_name'] = data['nick_name']
        #     item['image_link'] = data['vertical_src']

        # yield item
        # print(data)
