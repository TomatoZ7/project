import scrapy


class TencentSpider(scrapy.Spider):
    name = 'tencent'
    # allowed_domains = ['careers.tencent.com']
    start_urls = ['https://careers.tencent.com/search.html?&start=0']

    def parse(self, response):
        print('*' * 55)
        # node_list = response.xpath("//a[@class='recruit-list-link']")
        node_list = response.xpath("//div[@class='container']")
        print(response.text)
        print(node_list)
        # for node in node_list:
        #     yield {
        #         'name': node.xpath("./h4[@class='recruit-title']/text()"),
        #         'group': node.xpath("./p[@class='recruit-tips']/span[1]/text()")
        #     }
