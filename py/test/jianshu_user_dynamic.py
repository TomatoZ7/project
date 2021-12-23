"""
爬取简书网用户动态信息，并存储在 MongoDB
"""

import requests
from Utils.PyMongoUtil import db_test
from lxml import etree

# MongoDB 集合
collection = db_test['jianshu_user_dynamic']

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 '
                  'Safari/537.36 '
}


def get_dynamic(url, page):
    url_info = url.split('/')
    user_id = url_info[4]
    if url.find('page='):
        page = page + 1

    response = requests.get(url, headers=headers)
    print(response)
    selector = etree.HTML(response.text)

    infos = selector.xpath('//ul[@class="note-list"]/li')
    for info in infos:
        dd = info.xpath('div/div/div/span/@data-datetime')[0]
        note_type = info.xpath('div/div/div/span/@data-type')[0]

        collection.insert_one({'dd': dd, 'type': note_type})

    id_infos = selector.xpath('//ul[@class="note-list"]/li/@id')
    if len(infos) > 1:
        feed_id = id_infos[-1]
        max_id = int(feed_id.split('-')[1]) - 1
        next_page_url = 'https://www.jianshu.com/users/%s/timeline?max_id=%s&page=%s' % (user_id, max_id, page)
        get_dynamic(next_page_url, page)


if __name__ == '__main__':
    get_dynamic('https://www.jianshu.com/users/9104ebf5e177/timeline', 1)
