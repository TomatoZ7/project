"""
爬取简书专题信息
爬取的信息有：专题名称、专题介绍、收录文章和关注人数
"""

import scrapy
from scrapy.spiders import CrawlSpider
from scrapy.selector import Selector
from scrapy.http import Request
from scrapy_demo.items import JianshuTopic


class JianshuTopicSpider(scrapy.Spider):
    name = 'jianshu_topic'
    allowed_domains = ['']
    start_urls = ['https://www.jianshu.com/recommendations/collections?page={}&order_by=hot'.format(page) for page in range(1, 38)]
    custom_settings = {}

    def parse(self, response):
        item = JianshuTopic()

        selector = Selector(response)
        infos = selector.xpath('//div[@class="col-xs-8"]')

        for info in infos:
            name = info.xpath('div/a[1]/h4/text()').extract()[0]
            desc = info.xpath('div/a[1]/p/text()').extract()[0]
            article_num = info.xpath('div/div/a/text()').extract()[0]
            fan_num = info.xpath('div/div/text()').extract()[0]

            item['name'] = name
            item['desc'] = desc
            item['article_num'] = article_num
            item['fan_num'] = fan_num

            yield item
