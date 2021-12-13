"""
使用 Requests、Lxml、re 库，爬取豆瓣音乐 TOP250 的数据，并将数据存储到 MongoDB
需要爬取的信息有：歌曲名、表演者、流派、发行时间、出版者和评分
"""

import time
import requests
import re
import pymongo
from lxml import etree

# MongoDB
client = pymongo.MongoClient(host='127.0.0.1', port=27017, username="admin", password="admin")    # 记得换
db = client['test']
music_top = db['music_top']

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 ',
    'Cookie': 'bid=Lqusl1jjSk8; gr_user_id=e6d5fabe-d4eb-47f6-ab24-e1cd5b4045f7; __utmc=30149280; '
              '__utmz=30149280.1638893719.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); '
              '__gads=ID=a6a9449d60067c8d-221294d960cf00e3:T=1638893760:RT=1638893760:S'
              '=ALNI_Mbwd6OBJxC29pNk3MpJl6uGc7GdZA; _pk_ses.100001.afe6=*; ap_v=0,'
              '6.0; __utma=30149280.1368534518.1638893719.1638951882.1639119844.3; '
              '_vwo_uuid_v2=D32486634877F736AFAF3E4519EDBCEF6|88c46a206e7131cd22a7b1735d3d7979; '
              'viewed="1395089_1427374_2995812_35534519"; __utmt=1; dbcl2="197956574:/Atr7E9rAS0"; ck=2tyY; '
              '__utmt_douban=1; gr_session_id_22c937bbd8ebd703f2d8e9445f7dfd03=74191e93-d9e0-4834-8ef9-cc0603038c0a; '
              'gr_cs1_74191e93-d9e0-4834-8ef9-cc0603038c0a=user_id%3A1; '
              'gr_session_id_22c937bbd8ebd703f2d8e9445f7dfd03_74191e93-d9e0-4834-8ef9-cc0603038c0a=true; '
              '_pk_id.100001.afe6=176154929d430a20.1639119827.1.1639124819.1639119827.; push_noty_num=0; '
              'push_doumail_num=0; __utmv=30149280.19795; __utmb=30149280.12.10.1639119844 '
}

urls = ['https://music.douban.com/top250?start={}'.format(num) for num in range(0, 250, 25)]
detail_urls = []
musics = []


# 获取音乐详情链接
def get_detail_link(list_url):
    response = requests.get(list_url, headers=headers)

    if response.status_code == 200:
        selector = etree.HTML(response.text)
        items = selector.xpath('//tr[@class="item"]')
        for item in items:
            detail_url = item.xpath('td[1]/a/@href')[0]
            detail_urls.append(detail_url)
    else:
        print('HTTP 状态码错误：' + str(response.status_code) + '\r\n 链接: ' + list_url)
        exit()


# 爬取音乐数据
def get_music(music_url):
    response = requests.get(music_url, headers=headers)

    if response.status_code == 200:
        # 歌名
        name = re.findall('<div id="wrapper">\s+<h1>\s+<span>(.*?)</span>', response.text, re.S)[0]
        # 表演者
        singer = re.findall('表演者:[\s\S]*?>(.*?)</a>', response.text, re.S)[0]
        # 流派
        styles = re.findall('<span class="pl">流派:</span>&nbsp;(.*?)<br />', response.text, re.S)
        if len(styles):
            style = styles[0].strip()
        else:
            style = '未知'
        # 发行时间
        publish_time = re.findall('<span class="pl">发行时间:</span>&nbsp;(.*?)<br />', response.text, re.S)[0].strip()
        # 出版者
        publishers = re.findall('<span class="pl">出版者:</span>&nbsp;(.*?)<br />', response.text, re.S)
        if len(publishers):
            publisher = publishers[0].strip()
        else:
            publisher = '未知'
        # 评分
        score = re.findall('<strong class="ll rating_num" property="v:average">(.*?)</strong>', response.text, re.S)[0]

        row = {
            'name': name,
            'singer': singer,
            'style': style,
            'publish_time': publish_time,
            'publisher': publisher,
            'score': score
        }

        music_top.insert_one(row)

    else:
        print('状态异常：' + str(response.status_code))


if __name__ == '__main__':
    for url in urls:
        get_detail_link(url)

    for detail_url in detail_urls:
        get_music(detail_url)
        time.sleep(5)
