import scrapy


class QiushibaikeSpider(scrapy.Spider):
    name = 'qiushibaike'
    allowed_domains = ['www.qiushibaike.com']
    start_urls = ['https://www.qiushibaike.com/text/page/{}/'.format(page) for page in range(1, 2)]
    custom_settings = {}

    def parse(self, response):
        print(response)
        pass
