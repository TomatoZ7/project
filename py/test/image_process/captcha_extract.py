import os
import string
import matplotlib.pyplot as plt  # 图像处理/展现的相关函数库
import pytesseract
from PIL import Image

root_path = os.path.abspath(os.path.dirname(os.getcwd()))
data_path = os.path.join(root_path, 'data')

captcha = Image.open(os.path.join(data_path, 'captcha.jpg'))
# 备份
captcha.save('captcha_original.jpg')

gray = captcha.convert('L')
gray.save('captcha_gray.jpg')
bw = gray.point(lambda x: 0 if x < 1 else 255, '1')
bw.save('captcha_thresholded.jpg')

word = pytesseract.image_to_string(bw)
# ascii_word = ''.join(c for c in word if c in string.letters).lower()
print(word)
