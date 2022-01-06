import requests
from selenium import webdriver

driver = webdriver.Chrome(executable_path=r'/Applications/Google Chrome.app/Contents/MacOS/Google Chrome')

driver.maximize_window()
driver.get('https://www.bilibili.com/')
