import requests
import re


str = '<img src="https://profile.csdnimg.cn/5/4/2/1_han1202012"'
pattern = 'https?://[^\s)";]+\.(\w|/)*'
print(re.search(pattern, str))
