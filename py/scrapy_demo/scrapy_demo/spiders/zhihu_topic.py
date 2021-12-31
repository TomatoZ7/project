import scrapy


class ZhihuTopicSpider(scrapy.Spider):
    name = 'zhihu_topic'
    allowed_domains = ['www.zhihu.com']
    start_urls = ['http://https://www.zhihu.com/']

    def parse(self, response):
        pass
