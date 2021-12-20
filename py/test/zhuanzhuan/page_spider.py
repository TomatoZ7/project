"""
列表页爬取商品详情 URL,详情页爬取商品信息
"""

import requests
import time
from lxml import etree
from MongoUtil import db_test

# MongoDB
db_commodity_url = db_test['commodity_url']
db_commodity_info = db_test['commodity_info']

# 请求头
headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 ',
    'Connection': 'keep-alive'
}


# 获取商品 URL
def get_links(category_url, pages):
    list_url = '{}pn{}'.format(category_url, str(pages))

    try:

        response = requests.get(list_url, headers=headers)
        print(list_url, str(response.status_code))
        time.sleep(2)

        selector = etree.HTML(response.text)
        if selector.xpath('//tr'):
            infos = selector.xpath('//tr')

            for info in infos:
                if info.xpath('td[@class="t"]/div/a/@href'):
                    url = info.xpath('td[2]/div/a/@href')[0]
                    db_commodity_url.insert_one({'url': url})

    except requests.exceptions.ConnectionError:
        pass


# 获取商品信息
def get_info(url):
    response = requests.get(url, headers=headers)
    selector = etree.HTML(response.text)

    try:

        # 标题
        title = selector.xpath('//h1[@class="detail-title__name"]')[0]

        # 价格
        if selector.xpath('//span[@class="infocard__container__item__main__text--price"]'):
            price = selector.xpath('//span[@class="infocard__container__item__main__text--price"]')[0]
        else:
            price = ''

        # 地区
        if selector.xpath('//div[@class="infocard__container__item__main"]/a/text()'):
            area = selector.xpath('//div[@class="infocard__container__item__main"]/a/text()')[0]
        else:
            area = ''

        # 浏览次数
        view_num = selector.xpath('//span[@class="detail-title__info__totalcount"]/text()')[0]

        info = {
            'title': title,
            'price': price,
            'area': area,
            'view_num': view_num,
            'url': url
        }

        commodity_info.insert_one(info)

    except IndexError:
        print('get_links pass IndexError')
        pass
