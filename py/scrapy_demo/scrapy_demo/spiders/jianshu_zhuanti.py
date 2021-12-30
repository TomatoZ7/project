import scrapy


class JianshuZhuantiSpider(scrapy.Spider):
    name = 'jianshu_zhuanti'
    allowed_domains = ['']
    start_urls = ['http:///']

    def parse(self, response):
        pass
