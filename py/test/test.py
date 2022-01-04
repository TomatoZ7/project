import requests
import os
import uuid

# url = "http://sf3-cdn-tos.douyinstatic.com/obj/tos-cn-ve-2774/9ce9ccf7b08040618400671df5e7831e"
#
# response = requests.get(url)
#
# file = 'jianying.mp4'
#
# with open(file, 'wb') as f:
#     f.write(response.content)

try:

    type = 3

    if type == 1:  # 图片处理
        print(1)
    elif type == 2:  # 视频处理
        print(2)
    else:
        raise Exception(f'文件类型错误：{type}')

except Exception as e:
    print(e)
