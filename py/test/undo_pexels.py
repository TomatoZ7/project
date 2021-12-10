"""
把 PEXELS 的图片爬取到本地。
"""

import requests
import json
import os
from bs4 import BeautifulSoup

headers = {
    'accept': 'text/html, appli cat ioil/xhtml+xml,appli cat ion/xml; q=0.9, image/webp,*/*; q=0.8',
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}

if __name__ == '__main__':
    keywords = ['篮球', '美女', '豪车', '金钱']

    urls = ['https://www.pexels.com/zh-cn/search/{}/'.format(keyword) for keyword in keywords]

    for url in urls:
        data = requests.get(url, headers=headers)
        print(data)     # 403
