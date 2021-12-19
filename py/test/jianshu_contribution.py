"""
利用多进程爬虫方法，来爬取简书网“首页投稿”的热评文章数据，并存储数据到 MongoDB
需要爬取的信息有：用户名称、文章标题、文章内容、浏览量、评论数、点赞数和打赏数
"""

import requests
import pymongo
import re
from lxml import etree
from multiprocessing import Pool


# MongoDB
client = pymongo.MongoClient(host='120.77.82.77', port=27017, username="tz7", password="tz7")    # 记得换
db = client['test']
jianshu_contribution = db['jianshu_contribution']

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}


def get_info(url):
    response = requests.get(url, headers=headers)
    selector = etree.HTML(response.text)

    infos = selector.xpath('//ul[@class="note-list"]/li')
    for info in infos:
        try:

            name = info.xpath('div/div/a[1]/text()')[0]
            title = info.xpath('div/a[1]/text()')[0]
            content = info.xpath('div/p/text()')[0]
            # comment_num = info.xpath('div/div/a[2]/text()')[0]
            # like_num = info.xpath('/div/div/span[2]/text()')
            # rewards = info.xpath('div/div/span[3]/text()')
            # if len(rewards):
            #     reward_num = rewards[0]
            # else:
            #     reward_num = 0

            row_data = {
                'name': name,
                'title': title,
                'content': content,
                # 'comment_num': comment_num,
                # 'like_num': like_num,
                # 'reward_num': reward_num
            }
            jianshu_contribution.insert_one(row_data)

        except IndexError:
            print(url + ' - error')


if __name__ == '__main__':
    urls = ['https://www.jianshu.com/c/bDHhpK?order_by=commented_at&page={}'.format(page) for page in range(1, 10001)]

    # 创建进程池
    pool = Pool(processes=4)

    pool.map(get_info, urls)
