# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import json


class TutorialPipeline:
    def __init__(self):
        pass


class ITcastPipeline:
    def __init__(self):
        self.f = open("itcast_pipeline.json", "w")

    def process_item(self, item, spider):
        content = json.dumps(dict(item), ensure_ascii=False)
        # content = content.encode("utf-8")
        self.f.write(content)
        return item

    def close_spider(self, spider):
        self.f.close()
