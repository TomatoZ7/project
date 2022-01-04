"""
MacOS 剪映 APP 音效素材爬取
"""

import json
import os
import time
from hashlib import md5
from Utils.PyMongoUtil import db_test


class JianyingSong():
    CATEGORY_COMMAND = 'curl -H "Host: lv-pc-api.ulikecam.com" -H "Cookie: passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d; secure; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; passport_csrf_token_default=ee9baa898c542ecc790c5c16f8c8d12d; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; " -H "appvr: 2.5.1" -H "content-type: application/json" -H "device-time: 1640766814" -H "lan: zh-hans" -H "loc: cn" -H "pf: 4" -H "sign: 6c1a42bc24c1a640fc2f5e1cb9625f01" -H "sign-ver: 1" -H "tdid: 0" -H "x-tt-trace-id: 00-0552ba4f0d5e86c1310454dc74760e78-0552ba4f0d5e86c1-01" -H "user-agent: Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12" --data-binary "{}" --compressed "https://lv-pc-api.ulikecam.com/lv/v1/get_music_effect_collections"'
    SONG_COMMAND = 'curl -H "Host: lv-pc-api.ulikecam.com" -H "Cookie: passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d; secure; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; passport_csrf_token_default=ee9baa898c542ecc790c5c16f8c8d12d; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; " -H "appvr: 2.5.1" -H "content-type: application/json" -H "device-time: 1640766814" -H "lan: zh-hans" -H "loc: cn" -H "pf: 4" -H "sign: 62a200a1b23472e1b395472548067817" -H "sign-ver: 1" -H "tdid: 0" -H "x-tt-trace-id: 00-0552bc2d0d5e86c1310454d6b4ed0e78-0552bc2d0d5e86c1-01" -H "user-agent: Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12" --data-binary "{\\\"id\\\":%s,\\\"offset\\\":%s,\\\"count\\\":%s}" --compressed "https://lv-pc-api.ulikecam.com/lv/v1/get_collection_songs"'
    categories = []
    # 集合
    collection_media = db_test['jianying_sound']

    # 获取分类ID、名称
    def getCategory(self):
        print('分类请求 start')
        response = os.popen(self.CATEGORY_COMMAND).readlines()
        response_dict = json.loads(response[0])

        if int(response_dict['ret']) == 0:
            collections = response_dict['data']['collections']

            for collection in collections:
                category = {
                    'id': str(collection['id']),
                    'name': collection['name']
                }
                self.categories.append(category)

    # 获取音效素材
    def getInfo(self, category, offset=0, count=20):
        print('音效请求 start : ' + category['id'] + ' - ' + category['name'])

        category_id = category['id']
        command = self.SONG_COMMAND % (category_id, offset, count)

        response = os.popen(command).readlines()
        response_dict = json.loads(response[0])

        try:

            if int(response_dict.get('ret')) == 0:
                data = response_dict['data']

                for song in data['songs']:
                    # url 可能会变动，因此用 author+id 做唯一
                    url_md5 = md5(str(song['author'] + str(song['id'])).encode('utf-8')).hexdigest()

                    info = {
                        'tags': [],
                        'title': song['title'],
                        'category': category['name'],
                        'source': "jianying_app",
                        'type': 2,
                        'url': song['preview_url'],
                        'translate_stat': None,
                        'stat': 0,
                        'author': song['author'],
                        'headerUrl': '',
                        'url_md5': url_md5,
                        'cover_url': song['cover_url']['hd'],
                        'like_count': '',
                        'real_like_count': 0,
                        'duration': song['duration'],
                        'animated_cover_url': '',
                        'timestamp': song['update_time'],
                        'video_ratio': 0,
                        'llsid': '',
                        'id': song['id'],
                        'insert_time': int(time.time()),
                        'update_time': int(time.time()),
                        'rank': 0,
                        'hotValue': '',
                    }
                    self.collection_media.insert_one(info)

                time.sleep(2)

                # 是否还有数据
                if data['has_more']:
                    self.getInfo(category, offset+20, count)

        except Exception as e:
            print(e)

    def main(self):
        # 获取分类ID、名称
        self.getCategory()

        # 获取分类下音效素材
        for category in self.categories:
            self.getInfo(category)


if __name__ == '__main__':
    obj = JianyingSong()
    obj.main()
