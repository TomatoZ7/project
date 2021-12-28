"""
爬取剪映 APP 的音效素材
"""

import json
import requests

headers = {
    'user-agent': 'Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12',
    'cookie': 'passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d'
}

get_collection_url = 'https://lv-pc-api.ulikecam.com/lv/v1/get_music_effect_collections'
category = []


def get_collections(url):
    response = requests.post(url)
    response_dict = json.loads(response.text)

    collections = response_dict['data']['collections']

    for collection in collections:
        info = {
            'id': collection['id'],
            'name': collection['name']
        }
        category.append(info)


if __name__ == '__main__':
    get_collections(get_collection_url)

    pass
