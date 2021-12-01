# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
import json
import os


class ScrapyDemoPipeline:
    def __init__(self):
        path = os.path.split(os.path.realpath(__file__))[0]
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
