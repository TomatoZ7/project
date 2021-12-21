import sys
from multiprocessing import Pool
from category_spider import get_category_info, db_category, request_url
from commodity_spider import get_links, get_info, db_commodity_url, db_commodity_info
from MongoUtil import db_test


def category_spider(category_url):
    for num in range(1, 5):
        get_links(category_url, num)


if __name__ == '__main__':
    # 初始化变量
    category_urls = []  # 存放分类URL
    pool = Pool(processes=4)

    # 爬取分类名称&URL
    if not db_category.count_documents({}):
        get_category_info(request_url)

    # 查询数据库拿到所有分类URL
    categories = db_category.find()
    for category in list(categories):
        category_urls.append(category.get('url'))

    # 多进程爬取每个分类下商品的URL
    # pool.map(category_spider, category_urls)

    # 爬取商品信息
    all_commodity_urls = [item['url'] for item in db_commodity_url.find()]  # 所有商品URL
    exist_commodity_urls = [item['url'] for item in db_commodity_info.find()]  # 已经爬取的商品URL
    rest_commodity_urls = set(all_commodity_urls) - set(exist_commodity_urls)  # 未爬取的商品URL

    pool.map(get_info, rest_commodity_urls)
