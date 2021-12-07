"""
爬取糗事百科段子相关信息
爬取的信息有：用户名称、用户等级、用户性别、发表段子文字信息，好笑数量和评论数量
"""

import requests
import re
import os
import json

path = os.path.split(os.path.realpath(__file__))[0]
f = open(path + '/data/qiushi.json', 'w+')

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}

# 爬虫数据
data_list = []


def get_info(page_url):
    res = requests.get(page_url, headers=headers)
    text = res.text

    names = re.findall('<h2>\n(.*?)\n</h2>', text, re.S)
    levels = re.findall('<div class="articleGender \D+Icon">(.*?)</div>', text, re.S)
    genders = re.findall('<div class="articleGender (.*?)">.*?</div>', text, re.S)
    contents = re.findall('<div class="content">\n<span>(.*?)</span>', text, re.S)
    laughs = re.findall('<span class="stats-vote"><i class="number">(.*?)</i>', text, re.S)
    comments = re.findall('<span class="stats-comments">.*?<i class="number">(.*?)</i>', text, re.S)

    for name, level, gender, content, laugh, comment in zip(names, levels, genders, contents, laughs, comments):
        data = {
            "name": name,
            "level": level,
            "gender": get_gender(gender),
            "content": content.replace('\n', ''),
            "laugh_num": laugh,
            "comment_num": comment
        }

        data_list.append(data)


def get_gender(class_name):
    if class_name == 'manIcon':
        return 'man'
    else:
        return 'woman'


if __name__ == '__main__':
    urls = ['https://www.qiushibaike.com/text/page/{}/'.format(page) for page in range(1, 5)]

    for url in urls:
        get_info(url)

    try:
        f.write('[' + '\n')
        for data in data_list:
            f.write(json.dumps(data, ensure_ascii=False) + '\n')
    except UnicodeEncodeError:
        # pass 掉错误编码
        pass
