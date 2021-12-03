import re
import os

a = '1lwbnb2uzi3faker'
info = re.search('\d+', a)
print(info.groups())

path = os.path.split(os.path.realpath(__file__))[0]
print(os.path.realpath(__file__))
print(os.path.split(os.path.realpath(__file__)))
print(path)
