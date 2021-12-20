import sys
from multiprocessing import Pool
from channel_extract import channel_list
from page_spider import get_links


def get_all_links_from(channel):
    for num in range(1, 101):
        get_links(channel, num)


if __name__ == '__main__':
    pool = Pool(processes=4)

    pool.map(get_all_links_from, channel_list)
    # print(channel_list)
    # for channel in channel_list:
    #     get_all_links_from(channel)
