"""
QQ 空间好友说说
"""

from selenium import webdriver
from Utils.PyMongoUtil import db_test
from Utils.QQUtil import qq_friend_number, qq_number, qq_password
import time

# 指定 MongoDB 数据库
collection = db_test['qzone_friend_info']
# 选择浏览器
driver = webdriver.PhantomJS(executable_path=r'/Users/tz7/Tools/phantomjs-2.1.1-macosx/bin/phantomjs')
# 窗口最大化
driver.maximize_window()


def get_info(account):
    driver.get('http://user.qzone.qq.com/{}/311'.format(account))
    driver.implicitly_wait(10)  # 隐式等待 10s

    try:
        driver.find_element(value='login_div')
        need_login = True
    except:
        need_login = False

    if need_login:
        driver.switch_to.frame('login_frame')
        driver.find_element_by_id('switcher_plogin').click()
        driver.find_element_by_id('u').clear()
        driver.find_element_by_id('u').send_keys(qq_number)
        driver.find_element_by_id('p').clear()
        driver.find_element_by_id('p').send_keys(qq_password)
        driver.find_element_by_id('login_button').click()
        time.sleep(3)
        driver.implicitly_wait(10)

    try:
        driver.find_element_by_id('QM_OwnerInfo_Icon')
        is_visual = True
    except:
        is_visual = False

    if is_visual:
        driver.switch_to.frame('app_canvas_frame')
        contents = driver.find_elements_by_css_selector('.content')
        pub_times = driver.find_elements_by_css_selector('.c_tx.c_tx3.goDetail')
        for content, pub_time in zip(contents, pub_times):
            collection.insert_one({
                'content': content.text,
                'pub_time': pub_time.text
            })


if __name__ == "__main__":
    for qq in qq_friend_number:
        get_info(qq)
