"""
MacOS 剪映 APP 音效素材下载到本地
"""

import json
import os
import time
from hashlib import md5

import requests

from Utils.PyMongoUtil import db_test


class JianyingSongDownload():
    # 集合
    collection_media = db_test['jianying_medias']

    def getSound(self):
        cond = {
            'stat': 0
        }
        data = self.collection_media.find(cond)
        return data

    def main(self):
        sounds = self.getSound()
        for sound in sounds:
            print('start : ' + sound['title'])
            # 请求音频地址
            response = requests.get(sound['url'])
            # 文件名
            filename = sound['category'] + '_' + sound['title'].replace(' ', '&') + '.mp3'
            # 文件路径
            path = 'jianying_sound/' + filename
            # 写入文件
            with open(path, 'wb') as f:
                f.write(response.content)
            # 更新数据库状态
            self.collection_media.update_one({'_id': sound['_id']}, {'$set': {'stat': 1}})
            # 间隔时长
            time.sleep(5)


if __name__ == "__main__":
    obj = JianyingSongDownload()
    obj.main()
