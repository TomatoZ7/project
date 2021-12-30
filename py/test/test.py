import requests
import os

url = "http://sf3-cdn-tos.douyinstatic.com/obj/tos-cn-ve-2774/9ce9ccf7b08040618400671df5e7831e"

response = requests.get(url)

file = 'jianying.mp4'

with open(file, 'wb') as f:
    f.write(response.content)

print('ok')
