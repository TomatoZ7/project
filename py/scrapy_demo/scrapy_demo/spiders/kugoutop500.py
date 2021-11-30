import scrapy
from ..items import KugouTop500

'''
TODO
User-Agent 设置
download
'''


class Kugoutop500Spider(scrapy.Spider):
    name = 'kugoutop500'
    # allowed_domains = ['www.kugou']
    start_urls = ['http://www.kugou.com/yy/rank/home/{}-8888.html'.format(number) for number in range(1, 24)]

    def parse(self, response):
        for song_elem in response.css('div.pc_temp_songlist > ul > li'):
            item = KugouTop500()

            # 排名
            rank = song_elem.css('span.pc_temp_num::text').get().strip()
            if rank is None or len(rank) == 0:
                rank = song_elem.css('span.pc_temp_num>strong::text').get().strip()

            item['rank'] = rank
            item['song'] = song_elem.css('a::text').get().strip()
            item['singer'] = song_elem.css('a>span::text').get().strip().split('-')[1]
            item['duration'] = song_elem.css('span.pc_temp_time::text').get().strip()
            item['link_url'] = song_elem.css('a::attr("href")').extract_first()

            yield item
