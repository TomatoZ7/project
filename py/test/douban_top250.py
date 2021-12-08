"""
利用 Requests 和 Lxml 库，爬取豆瓣网图书 TOP250 数据，并存储到 CSV 格式的文件中。
爬取的信息有：书名、书的 URL 链接、作者、出版社和出版时间，书本价格、评分和评价
"""

import csv
import os
import requests
from lxml import etree

path = os.path.split(os.path.realpath(__file__))[0]

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}

# 创建 csv
f = open(path + '/data/douban_book.csv', 'wt', newline='', encoding='utf-8')

# 写入 header
writer = csv.writer(f)
writer.writerow(('书名', '网页链接', '作者', '出版社', '出版日期', '价格', '评分', '简介'))


def get_info(url):
    html = requests.get(url, headers=headers)

    selector = etree.HTML(html.text)
    info_containers = selector.xpath('//tr[@class="item"]')
    for info in info_containers:
        name = info.xpath('td/div/a/@title')[0]
        link = info.xpath('td/div/a/@href')[0]

        book_info = info.xpath('td/p/text()')[0].split('/')
        author = book_info[0]
        publisher = book_info[-3]
        publish_date = book_info[-2]
        price = book_info[-1]

        score = info.xpath('td/div/span[@class="rating_nums"]/text()')[0]

        comment_container = info.xpath('td/p/span[@class="inq"]/text()')
        comment = comment_container[0] if len(comment_container) else ''

        # 写入
        writer.writerow([name, link, author, publisher, publish_date, price, score, comment])


if __name__ == '__main__':
    urls = ['https://book.douban.com/top250?start={}'.format(rank) for rank in range(0, 250, 25)]

    for url in urls:
        get_info(url)

    f.close()
