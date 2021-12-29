import requests
import os

curl_str = """
curl -H "Host: lv-pc-api.ulikecam.com" -H "Cookie: passport_csrf_token=ee9baa898c542ecc790c5c16f8c8d12d; secure; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; passport_csrf_token_default=ee9baa898c542ecc790c5c16f8c8d12d; expires=Thu, 24-Feb-2022 02:31:29 GMT; domain=.ulikecam.com; path=/; " -H "appvr: 2.5.1" -H "content-type: application/json" -H "device-time: 1640766814" -H "lan: zh-hans" -H "loc: cn" -H "pf: 4" -H "sign: 6c1a42bc24c1a640fc2f5e1cb9625f01" -H "sign-ver: 1" -H "tdid: 0" -H "x-tt-trace-id: 00-0552ba4f0d5e86c1310454dc74760e78-0552ba4f0d5e86c1-01" -H "user-agent: Cronet/TTNetVersion:dcc8541d 2021-09-28 QuicVersion:68cae75d 2021-08-12" --data-binary "{}" --compressed "https://lv-pc-api.ulikecam.com/lv/v1/get_music_effect_collections"
"""

res = os.popen(curl_str).readlines()

print(res)