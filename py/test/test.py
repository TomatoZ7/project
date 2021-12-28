import requests

param = {
    "id": 6697775630102039307,
    "offset": 20,
    "count": 20
}

response = requests.post('https://lv-pc-api.ulikecam.com/lv/v1/get_collection_songs', data=param)

print(response)
