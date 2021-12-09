# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class ScrapyDemoItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass


# 酷狗榜单 top 500
class KugouTop500(scrapy.Item):
    rank = scrapy.Field()
    singer = scrapy.Field()
    song = scrapy.Field()
    duration = scrapy.Field()
    link_url = scrapy.Field()


# 腾讯社招岗位
class TencentPositionItem(scrapy.Item):
    name = scrapy.Field()
    group = scrapy.Field()
    address = scrapy.Field()
    type = scrapy.Field()
    pub_date = scrapy.Field()
    detail_link = scrapy.Field()


# 斗鱼主播
class DouyuAnchorItem(scrapy.Item):
    nick_name = scrapy.Field()
    image_link = scrapy.Field()


# 斗破章节
class DoupoChapter(scrapy.Item):
    content = scrapy.Field()


# 糗事百科段子
class QiushiItem(scrapy.Item):
    name = scrapy.Field()
    level = scrapy.Field()
    gender = scrapy.Field()
    content = scrapy.Field()
    laugh_num = scrapy.Field()
    comment_num = scrapy.Field()


# 豆瓣书籍
class DoubanBookItem(scrapy.Item):
    name = scrapy.Field()
    link = scrapy.Field()
    author = scrapy.Field()
    publisher = scrapy.Field()
    publish_date = scrapy.Field()
    price = scrapy.Field()
    score = scrapy.Field()
    desc = scrapy.Field()


# 起点小说
class QidianNovelItem(scrapy.Item):
    name = scrapy.Field()
    author = scrapy.Field()
    type = scrapy.Field()
    sub_type = scrapy.Field()
    finish_type = scrapy.Field()
    desc = scrapy.Field()
