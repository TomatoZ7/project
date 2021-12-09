"""
利用 Requests 和 Lxml 第三方库，爬取起点中文网小说信息，运用 xlwt 库存储为 Excel 格式
爬取的信息有：小说名，作者、小说类型、完成情况、摘要和字数
"""

import scrapy
from ..items import QidianNovelItem
from lxml import etree


class QidianNovelSpider(scrapy.Spider):
    name = 'qidian_novel'
    allowed_domains = ['www.qidian.com']
    start_urls = ['https://www.qidian.com/all/page{}/'.format(page) for page in range(1, 6)]
    custom_settings = {
        'ITEM_PIPELINES': {'scrapy_demo.pipelines.QidianNovelPipeline': 400}
    }

    def parse(self, response):
        item = QidianNovelItem()

        selector = etree.HTML(response.text)

        novel_containers = selector.xpath('//div[@class="book-img-text"]/ul/li')
        for container in novel_containers:
            item['name'] = container.xpath('div/h2/a/text()')[0]
            item['author'] = container.xpath('div/p[@class="author"]/a[1]/text()')[0]
            item['type'] = container.xpath('div/p[@class="author"]/a[2]/text()')[0]
            item['sub_type'] = container.xpath('div/p[@class="author"]/a[3]/text()')[0]
            item['finish_type'] = container.xpath('div/p[@class="author"]/span/text()')[0]
            item['desc'] = container.xpath('div/p[@class="intro"]/text()')[0].strip()

            yield item
