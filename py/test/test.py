import requests
from selenium import webdriver

options = webdriver.ChromeOptions()
options.binary_location = '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome'
driver = webdriver.Chrome(executable_path=r'/Users/tz7/Tools/chromedriver_97', chrome_options=options)

driver.maximize_window()
driver.get('https://www.baidu.com/')
