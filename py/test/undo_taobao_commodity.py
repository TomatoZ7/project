"""
使用 Selenium 和 PhantomJS，模拟计算机搜索和翻页操作，爬取淘宝网编程书的信息
"""

from selenium import webdriver
from lxml import etree
from Utils.PyMongoUtil import db_test
import time

# 指定 MongoDB 数据库
collection = db_test['it_book']
# 选择浏览器
driver = webdriver.PhantomJS(executable_path=r'/Users/tz7/Tools/phantomjs-2.1.1-macosx/bin/phantomjs')
# 窗口最大化
driver.maximize_window()


def get_info(url, page):
    driver.get(url)
    driver.implicitly_wait(10)

    page_source = driver.page_source
    current_url = driver.current_url

    selector = etree.HTML(driver.page_source)
    infos = selector.xpath('//div[@class="item J_MouserOnverReq"]')
    print()


if __name__ == "__main__":
    page = 1
    url = 'https://www.taobao.com/'
    search_url = 'https://s.taobao.com/search?q=%E7%BC%96%E7%A8%8B%E4%B9%A6%E7%B1%8D&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20211229&ie=utf8'
    # driver.get(url)  # 请求 url 请求不到完整 html 文本
    # driver.implicitly_wait(10)
    # search
    # driver.find_element_by_id('q').clear()
    # driver.find_element_by_id('q').send_keys('彩妆')
    # driver.find_element_by_class_name('btn-search').click()
    get_info(search_url, page)
