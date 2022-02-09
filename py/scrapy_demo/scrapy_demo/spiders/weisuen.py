import scrapy


class WeisuenSpider(scrapy.Spider):
    name = 'weisuen'
    allowed_domains = ['sina.com.cn']
    start_urls = [
        'http://slide.news.sina.com.cn/s/slide_1_2841_103185.html',
        'http://slide.mil.news.sina.com.cn/k/slide_8_193_45192.html#p=1',
        'http://news.sina.com.cn/pl/2016-09-12/doc-ifxvukhv8147404.shtml'
    ]

    def parse(self, response):
        url_name = response.xpath('/html/head/title/text()')
        print(url_name)
