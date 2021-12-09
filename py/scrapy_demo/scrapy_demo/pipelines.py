# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
import json
import os
import scrapy
import csv

import xlwt
from scrapy.pipelines.images import ImagesPipeline

path = os.path.split(os.path.realpath(__file__))[0]


class ScrapyDemoPipeline:
    def __init__(self):
        self.f = open(path + "/data/kugou_top_500.json", "w")
        self.f.write('[ \n')

    def open_spider(self, spider):
        pass

    def process_item(self, item, spider):
        content = json.dumps(dict(item), ensure_ascii=False) + ',\n'
        content.encode('utf-8')
        self.f.write(content)
        return item

    def close_spider(self, spider):
        self.f.write(']')
        self.f.close()


class DouyuVerticalRoomPipeline(ImagesPipeline):
    # def get_media_requests(self, item, info):
    #     image_link = item['image_link']
    #     yield scrapy.Request(image_link)
    def process_item(self, item, spider):
        print(item)
        return item


class DoupoPipeline:
    def __init__(self):
        self.f = open(path + "/data/doupo.txt", "w+")

    def process_item(self, item, spider):
        self.f.write(item['content'] + '\n')

    def close_spider(self, spider):
        self.f.close()


class QiushiPipeline:
    def __init__(self):
        self.f = open(path + "/data/qiushi.json", "w+")
        self.f.write('[ \n')

    def process_item(self, item, spider):
        content = json.dumps(dict(item), ensure_ascii=False) + ',\n'
        self.f.write(content)
        return item

    def close_spider(self, spider):
        self.f.write(']')
        self.f.close()


# csv 格式存储
class DoubanBookTop250:
    def __init__(self):
        self.f = open(path + '/data/douban_book_top250.csv', 'wt', newline='', encoding='utf-8')
        # csv
        self.writer = csv.writer(self.f)
        self.writer.writerow(('书名', '网页链接', '作者', '出版社', '出版日期', '价格', '评分', '简介'))

    def process_item(self, item, spider):
        self.writer.writerow(list(dict(item).values()))
        # print(dict(item))

    def close_spider(self, spider):
        self.f.close()


# excel 格式存储
class QidianNovelPipeline:
    def __init__(self):
        # 创建表格
        self.work_book = xlwt.Workbook(encoding='utf-8')
        # 创建 sheet
        self.sheet = self.work_book.add_sheet('起点小说')
        # 列宽
        for i in range(0, 6):
            column = self.sheet.col(i)
            column.width = 256 * 20
        # 表头
        header = ['小说名', '作者', '大类', '子类', '状态', '简介']
        for h in range(len(header)):
            self.sheet.write(0, h, header[h])
        # 行
        self.row = 1

    def process_item(self, item, spider):
        col = 0
        cell_data = dict(item).values()
        for data in cell_data:
            self.sheet.write(self.row, col, str(data))
            col += 1
        self.row += 1

    def close_spider(self, spider):
        self.work_book.save(path + '/data/qidian_novel.xls')
