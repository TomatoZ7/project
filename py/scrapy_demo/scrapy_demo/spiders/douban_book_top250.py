"""
利用 Requests 和 Lxml 库，爬取豆瓣网图书 TOP250 数据，并存储到 CSV 格式的文件中。
爬取的信息有：书名、书的 URL 链接、作者、出版社和出版时间，书本价格、评分和评价
"""

import scrapy
from lxml import etree
from ..items import DoubanBookItem


class DoubanBookTop250Spider(scrapy.Spider):
    name = 'douban_book_top250'
    allowed_domains = ['book.douban.com']
    start_urls = ['http://book.douban.com/top250?start={}'.format(num) for num in range(0, 250, 25)]
    custom_settings = {
        'ITEM_PIPELINES': {'scrapy_demo.pipelines.DoubanBookTop250': 400}
    }

    def parse(self, response):
        book_item = DoubanBookItem()

        selector = etree.HTML(response.text)

        items = selector.xpath('//tr[@class="item"]')
        for item in items:
            book_info = item.xpath('td/p/text()')[0].split('/')
            comment_info = item.xpath('td/p/span[@class="inq"]/text()')

            book_item['name'] = item.xpath('td/div/a/@title')[0]
            book_item['link'] = item.xpath('td/div/a/@href')[0]
            book_item['author'] = book_info[0]
            book_item['publisher'] = book_info[-3]
            book_item['publish_date'] = book_info[-2]
            book_item['price'] = book_info[-1]
            book_item['score'] = item.xpath('td/div/span[@class="rating_nums"]/text()')[0]
            book_item['desc'] = comment_info[0] if len(comment_info) else ''

            yield book_item
