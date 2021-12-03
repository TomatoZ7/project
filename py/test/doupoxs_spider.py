import os
import requests
import re
import time

'''
http://www.doupoxs.com/doupocangqiong/1.html
章节内容
'''

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}

path = os.path.split(os.path.realpath(__file__))[0]
f = open(path + '/data/doupo.txt', 'w+')


# 获取信息
def get_info(page_url):
    res = requests.get(page_url, headers=headers)
    if res.status_code == 200:
        contents = re.findall('<p>(.*?)</p>', res.content.decode('utf-8'), re.S)
        for content in contents:
            f.write(content + '\n')


if __name__ == '__main__':
    urls = ['http://www.doupoxs.com/doupocangqiong/{}.html'.format(page) for page in range(1, 11)]  # 1665

    for url in urls:
        print(url)
        get_info(url)
        time.sleep(1)

    f.close()
