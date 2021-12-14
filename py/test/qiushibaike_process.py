"""
爬取糗事百科段子页用户名、段子信息、好笑数量和评论数量
主要是通过 多进程爬虫 来对比性能差异
"""

import time
import re
from multiprocessing import Pool
import requests

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}


def get_info(page_url):
    res = requests.get(page_url, headers=headers)
    text = res.text

    names = re.findall('<h2>\n(.*?)\n</h2>', text, re.S)
    contents = re.findall('<div class="content">\n<span>(.*?)</span>', text, re.S)
    laughs = re.findall('<span class="stats-vote"><i class="number">(.*?)</i>', text, re.S)
    comments = re.findall('<span class="stats-comments">.*?<i class="number">(.*?)</i>', text, re.S)

    for name, content, laugh, comment in zip(names, contents, laughs, comments):
        data = {
            "name": name,
            "content": content.replace('\n', ''),
            "laugh_num": laugh,
            "comment_num": comment
        }

        return data


if __name__ == '__main__':
    urls = ['https://www.qiushibaike.com/text/page/{}/'.format(page) for page in range(1, 11)]

    start_1 = time.time()
    for url in urls:
        get_info(url)
    end_1 = time.time()
    print('串行爬虫 : ' + str(end_1 - start_1))

    start_2 = time.time()
    pool = Pool(processes=2)
    pool.map(get_info, urls)
    end_2 = time.time()
    print('2 个进程 : ' + str(end_2 - start_2))

    start_3 = time.time()
    pool = Pool(processes=3)
    pool.map(get_info, urls)
    end_3 = time.time()
    print('4 个进程 : ' + str(end_3 - start_3))
