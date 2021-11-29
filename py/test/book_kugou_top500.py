from bs4 import BeautifulSoup
import requests
import time
import random

'''
爬取酷狗网页 TOP500 音乐信息
爬取的信息有：排名情况、歌手、歌曲名和歌曲时间
'''

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.55 Safari/537.36 '
}


# 获取 url 信息
def get_info(url):
    wb_data = requests.get(url, headers=headers)
    soup = BeautifulSoup(wb_data.text, 'lxml')
    ranks = soup.select('span.pc_temp_num')
    song_infos = soup.select('div.pc_temp_songlist > ul > li > a')   # 这里包含了歌手名&歌曲名
    durations = soup.select('span.pc_temp_time')

    # py3 zip 返回的是一个对象，需用 list 转
    for rank, song_info, duration in list(zip(ranks, song_infos, durations)):
        data = {
            'rank': rank.get_text().strip(),
            'singer': song_info.get_text().split('-')[0].strip(),
            'song': song_info.get_text().split('-')[1].strip(),
            'duration': duration.get_text().strip()
        }

        print(data)


if __name__ == '__main__':
    urls = ['https://www.kugou.com/yy/rank/home/{}-8888.html'.format(number) for number in range(1, 24)]

    for url in urls:
        get_info(url)
        time.sleep(random.randint(1, 3))
