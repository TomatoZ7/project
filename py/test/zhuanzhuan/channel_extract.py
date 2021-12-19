"""
爬取商品分类 URL，把爬取的 URL 信息打印到屏幕上，过滤二手手机号的 URL，通过三引号存为字符串
"""

import requests
from lxml import etree

host_url = 'http://cs.58.com'
request_url = host_url + '/sale.shtml'


def get_channel_urls(url):
    response = requests.get(url)
    selector = etree.HTML(response.text)

    infos = selector.xpath('//div[@class="lbsear"]/div/ul/li')
    for info in infos:
        cate_urls = info.xpath('span/a/@href')
        for cate_url in cate_urls:
            print(host_url + cate_url)


if __name__ == '__main__':
    get_channel_urls(request_url)
