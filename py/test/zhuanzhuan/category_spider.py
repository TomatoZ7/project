"""
爬取商品分类 URL，把爬取的 URL 和分类名称存入 MongoDB
"""

import requests
from lxml import etree
from MongoUtil import db_test

host_url = 'http://cs.58.com'
request_url = host_url + '/sale.shtml'

db_category = db_test['category']


def get_category_info(url):
    response = requests.get(url)
    selector = etree.HTML(response.text)

    infos = selector.xpath('//div[@class="lbsear"]/div/ul/li')
    for info in infos:
        categories = info.xpath('span/a')
        for category in categories:
            link = category.xpath('@href')
            name = category.xpath('text()')

            if name and link:
                db_category.insert_one({
                    'url': host_url + link[0],
                    'name': name[0]
                })