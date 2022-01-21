import requests
from selenium import webdriver

# options = webdriver.ChromeOptions()
# options.binary_location = '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome'
# driver = webdriver.Chrome(executable_path=r'/Users/tz7/Tools/chromedriver_97', chrome_options=options)
#
# driver.maximize_window()
# driver.get('https://www.baidu.com/')
import re

string = "hellomypythonhispythonourpythonend"

pattern = re.compile("python.")
res1 = re.sub(pattern, "php", string)
res2 = re.sub(pattern, "php", string, 2)
print(res1)  # hellomyphpisphpurphpnd
print(res2)  # hellomyphpisphpurpythonend
