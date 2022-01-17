import requests
from selenium import webdriver

# options = webdriver.ChromeOptions()
# options.binary_location = '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome'
# driver = webdriver.Chrome(executable_path=r'/Users/tz7/Tools/chromedriver_97', chrome_options=options)
#
# driver.maximize_window()
# driver.get('https://www.baidu.com/')
import re

string = "abcdfphp345pythony_py"

pattern1 = "p.*y"  # 贪婪模式
res1 = re.search(pattern1, string)
print(res1)  # <re.Match object; span=(5, 21), match='php345Pythony_py'>

pattern2 = "p.*?y"
res2 = re.search(pattern2, string, re.I)
print(res2)  # <re.Match object; span=(5, 13), match='php345Py'>

# pattern3 = "cd{3}"
# res3 = re.search(pattern3, string)
# print(res3)  # <re.Match object; span=(2, 6), match='cddd'>
#
# pattern4 = "cd{2,}"
# res4 = re.search(pattern4, string)
# print(res4)  # <re.Match object; span=(2, 6), match='cddd'>
