"""
利用百度地图 API，对糗事百科网的用户地址进行经纬度的转换，并通过个人 BDP 进行地图上的可视化。
"""

import requests
from lxml import etree

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}


if __name__ == "__main__":
    domain = 'https://www.qiushibaike.com'
    urls = [domain + '/8hr/page/{}/'.format(page) for page in range(1, 11)]
    user_urls = []

    # 获取用户链接
    for url in urls:
        response = requests.get(url, headers=headers)
        html = etree.HTML(response.text)
        user_link = html.xpath('//a[@class="recmd-user"]/@href')

        user_urls += user_link

    #
    for url in user_urls:
        response = requests.get(domain + url)
        html = etree.HTML(response.text)
        home = html.xpath('//div[@class="user-statis user-block"][2]/ul/li[5]/text()')
        if len(home):
            address = home[0].split(' · ')[0]
            # todo 调用 api 获取地理坐标
