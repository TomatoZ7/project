import json
import scrapy
from ..items import DouyuAnchorItem


class DouyuVerticalRoomSpider(scrapy.Spider):
    name = 'douyu_vertical_room'
    allowed_domains = ['douyucdn.cn']
    start_urls = ['http://capi.douyucdn.cn/api/v1/getVerticalRoom?limit=20&offset=0']

    def parse(self, response):
        item = DouyuAnchorItem()

        data_list = json.loads(response.body)['data']
        for data in data_list:
            item['nick_name'] = data['nick_name']
            item['image_link'] = data['vertical_src']

            yield item
