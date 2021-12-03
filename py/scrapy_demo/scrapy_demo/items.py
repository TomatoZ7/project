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
