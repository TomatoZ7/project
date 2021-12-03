import scrapy
import re
from ..items import DoupoChapter


class DoupoSpider(scrapy.Spider):
    name = 'doupo'
    allowed_domains = ['www.doupoxs.com']
    start_urls = ['http://www.doupoxs.com/doupocangqiong/{}.html'.format(page) for page in range(1, 2)]  # 1665
    custom_settings = {
        'ITEM_PIPELINES': {'scrapy_demo.pipelines.DoupoPipeline': 400}
    }

    def parse(self, response):
        if response.status == 200:
            item = DoupoChapter()

            contents = re.findall('<p>(.*?)</p>', response.body.decode('utf-8'), re.S)
            for content in contents:
                item['content'] = content
                yield item
