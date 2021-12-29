"""
爬取剪映 APP 的音效素材
"""

import json
import requests
import os

curl_category = """
curl -H "Host: lv-pc-api.ulikecam.com" -H "Cookie: passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d; secure; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; passport_csrf_token_default=ee9baa898c542ecc790c5c16f8c8d12d; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; " -H "appvr: 2.5.1" -H "content-type: application/json" -H "device-time: 1640766814" -H "lan: zh-hans" -H "loc: cn" -H "pf: 4" -H "sign: 6c1a42bc24c1a640fc2f5e1cb9625f01" -H "sign-ver: 1" -H "tdid: 0" -H "x-tt-trace-id: 00-0552ba4f0d5e86c1310454dc74760e78-0552ba4f0d5e86c1-01" -H "user-agent: Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12" --data-binary "{}" --compressed "https://lv-pc-api.ulikecam.com/lv/v1/get_music_effect_collections"
"""

curl_songs = """
curl -H "Host: lv-pc-api.ulikecam.com" -H "Cookie: passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d; secure; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; passport_csrf_token_default=ee9baa898c542ecc790c5c16f8c8d12d; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; " -H "appvr: 2.5.1" -H "content-type: application/json" -H "device-time: 1640766814" -H "lan: zh-hans" -H "loc: cn" -H "pf: 4" -H "sign: 62a200a1b23472e1b395472548067817" -H "sign-ver: 1" -H "tdid: 0" -H "x-tt-trace-id: 00-0552bc2d0d5e86c1310454d6b4ed0e78-0552bc2d0d5e86c1-01" -H "user-agent: Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12" --data-binary "{\"id\":{},\"offset\":{},\"count\":{}}" --compressed "https://lv-pc-api.ulikecam.com/lv/v1/get_collection_songs"
"""

categories = []


def get_collections():
    response = os.popen(curl_category).readlines()
    response_dict = json.loads(response[0])

    if int(response_dict.get('ret')) == 0:
        collections = response_dict['data']['collections']

        for collection in collections:
            info = {
                'id': str(collection['id']),
                'name': collection['name']
            }
            categories.append(info)


def get_songs(collection, offset=0, count=20):
    print(collection)
    category_id = collection['id']
    # url = curl_songs.format(str(category_id), offset, count)
    print(category_id)
    # response = os.popen(curl_songs.format(str(category_id, str(offset), str(count)))).readlines()


if __name__ == '__main__':
    get_collections()

    if len(categories):
        for category in categories:
            get_songs(category)
