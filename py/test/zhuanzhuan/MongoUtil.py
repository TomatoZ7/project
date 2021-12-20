"""
MongoDB 链接
"""

import pymongo

client = pymongo.MongoClient(host='120.77.82.77', port=27017, username="tz7", password="tz7")  # 记得换
db_test = client['test']
