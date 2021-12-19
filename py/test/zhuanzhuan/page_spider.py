
import pymongo
import requests
import time
from lxml import etree

# MongoDB
client = pymongo.MongoClient(host='120.77.82.77', port=27017, username="tz7", password="tz7")    # 记得换
db = client['test']
jianshu_contribution = db['jianshu_contribution']
