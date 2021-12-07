"""
爬取糗事百科段子相关信息
爬取的信息有：用户名称、用户等级、用户性别、发表段子文字信息，好笑数量和评论数量
"""

import scrapy
import re
from ..items import QiushiItem


class QiushibaikeSpider(scrapy.Spider):
    name = 'qiushibaike'
    allowed_domains = ['www.qiushibaike.com']
    start_urls = ['https://www.qiushibaike.com/text/page/{}/'.format(page) for page in range(1, 2)]
    custom_settings = {
        'ITEM_PIPELINES': {'scrapy_demo.pipelines.QiushiPipeline': 400}
    }

    def parse(self, response):
        item = QiushiItem()

        body = response.body.decode('utf-8')

        names = re.findall('<h2>\n(.*?)\n</h2>', body, re.S)
        levels = re.findall('<div class="articleGender \D+Icon">(.*?)</div>', body, re.S)
        genders = re.findall('<div class="articleGender (\w+)Icon">.*?</div>', body, re.S)
        contents = re.findall('<div class="content">\n<span>(.*?)</span>', body, re.S)
        laughs = re.findall('<span class="stats-vote"><i class="number">(.*?)</i>', body, re.S)
        comments = re.findall('<span class="stats-comments">.*?<i class="number">(.*?)</i>', body, re.S)

        for name, level, gender, content, laugh, comment in zip(names, levels, genders, contents, laughs, comments):
            item['name'] = name
            item['level'] = level
            item['gender'] = gender
            item['content'] = content
            item['laugh_num'] = laugh
            item['comment_num'] = comment

            yield item
