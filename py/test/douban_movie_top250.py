"""
利用 Requests、Lxml 和 re 第三方库，爬取豆瓣电影 TOP250 的数据，并将数据存储到 MySQL 数据库中
爬取的信息有：电影名称、导演、主演、类型、制片国家、上映时间、片长和评分
"""

import time
import requests
import re
import pymysql
from lxml import etree

# mysql
conn = pymysql.connect(host='127.0.0.1', user='root', database='py_test')
cursor = conn.cursor()

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 ',
    'cookie': 'bid=Lqusl1jjSk8; gr_user_id=e6d5fabe-d4eb-47f6-ab24-e1cd5b4045f7; __utmc=30149280; '
              '__utmz=30149280.1638893719.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); '
              '__gads=ID=a6a9449d60067c8d-221294d960cf00e3:T=1638893760:RT=1638893760:S'
              '=ALNI_Mbwd6OBJxC29pNk3MpJl6uGc7GdZA; viewed="1395089_1427374_2995812_35534519"; '
              'dbcl2="197956574:/Atr7E9rAS0"; ck=2tyY; push_noty_num=0; push_doumail_num=0; __utmv=30149280.19795; '
              '__utmc=223695111; __utmz=223695111.1639385322.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); '
              'll="118281"; _vwo_uuid_v2=DC0EF54070F56938F357BE55E1C4C77DD|8f47eb66c769f6ab2a028b41bc44022a; ap_v=0,'
              '6.0; __utma=30149280.1368534518.1638893719.1639385321.1639460866.9; '
              '__utma=223695111.617627745.1639385322.1639385322.1639460866.2; '
              '_pk_id.100001.4cf6=d7625536b8ef39af.1639385321.2.1639461417.1639386117. '
}

list_urls = ['https://movie.douban.com/top250?start={}'.format(num) for num in range(0, 250, 25)]
detail_urls = []
movies = []


def get_detail_link(url):
    response = requests.get(url, headers=headers)

    if response.status_code == 200:
        selector = etree.HTML(response.text)
        items = selector.xpath('//div[@class="item"]')
        for item in items:
            detail_link = item.xpath('div[@class="pic"]/a/@href')[0]
            detail_urls.append(detail_link)
    else:
        print('HTTP 状态码错误：' + str(response.status_code) + '\r\n 链接: ' + url)


def get_movie(url):
    response = requests.get(url, headers=headers)

    selector = etree.HTML(response.text)

    try:
        # 电影名
        name = re.findall('<span property="v:itemreviewed">(.*?)</span>', response.text, re.S)[0]
        # 导演
        director = re.findall('<a href=".*?" rel="v:directedBy">(.*?)</a>', response.text, re.S)[0]
        # 主演
        actors = selector.xpath('//div[@id="info"]/span[3]/span[@class="attrs"]')
        if len(actors):
            actor = actors[0].xpath('string(.)')
        else:
            actor = ''
        # 制片国家
        country = re.findall('制片国家/地区:</span>(.*?)<br/>', response.text, re.S)[0].strip()
        # 上映日期
        release_date = re.findall('上映日期:</span>[\s\S]*?>(.*?)</span>', response.text, re.S)[0]
        # 片长
        duration = re.findall('片长:</span>[\s\S]*?>(.*?)</span>', response.text, re.S)[0]
        # 评分
        score = re.findall('<strong class="ll rating_num" property="v:average">(.*?)</strong>', response.text, re.S)[0]

        # 入库
        cursor.execute(
            'INSERT INTO douban_movie_rank(name, director, actor, country, release_date, duration, score) '
            ' VALUES(%s, %s, %s, %s, %s, %s, %s)'
            , (str(name), str(director), str(actor), str(country), str(release_date), str(duration), str(score)))

    except IndexError:
        print(url + ' - error')


if __name__ == '__main__':
    for list_url in list_urls:
        get_detail_link(list_url)
        time.sleep(2)

    for detail_url in detail_urls:
        get_movie(detail_url)
        time.sleep(2)

    conn.commit()
