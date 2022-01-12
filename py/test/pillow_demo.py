# -*- coding: utf-8 -*-
import warnings
import os
import matplotlib.pyplot as plt  # 图像处理/展现的相关函数库
from PIL import Image, ImageDraw, ImageFont

warnings.filterwarnings('ignore')

# 根目录路径
root_path = os.getcwd()
# 训练验证用的资料目录
data_path = os.path.join(root_path, 'data')
# 测试用的图像
test_image = os.path.join(data_path, 'Irelia.jpg')

# 载入图像
image = Image.open(test_image)

# 存储图像并转换格式（jpg->png）
# image.save(os.path.join(data_path, 'new_image.png'))

# 调整图像大小
# new_image = image.resize((400, 400))
# print('原图像大小:', image.size)
# print('新图像大小:', new_image.size)

# 按比例缩放
# image.thumbnail((200, 200))
# print(image.size)

# 图像裁剪
# 定义要裁剪的边界框坐标
# x1 = 0
# y1 = 50
# x2 = 460
# y2 = 320
# bbox = (x1, y1, x2, y2)
# # 进行裁剪
# cropped_image = image.crop(bbox)

# 将图像粘贴在另一个图像上
# # 载入另一张图像
# watermark_image = Image.open(os.path.join(data_path, 'Irelia_o.jpg'))
# # 改成合适的大小
# watermark_image.thumbnail((100, 100))
# # 复制图像
# image_copy = image.copy()
# # 指定要粘贴的左上角坐标
# position = ((image_copy.width - watermark_image.width), (image_copy.height - watermark_image.height))
# # 进行粘贴
# image_copy.paste(watermark_image, position)

# 图像旋转
# 逆时针旋转 90°
# image_rot_90 = image.rotate(90, expand=True)
# 逆时针旋转 180°
# image_rot_180 = image.rotate(180)

# 图像翻转
# 左右互换
# image_flip = image.transpose(Image.FLIP_LEFT_RIGHT)
# 上下互换
# image_flip = image.transpose(Image.FLIP_TOP_BOTTOM)

# 在图像上绘图
# # 产生一个有 4 个颜色 channels 的空白图像
# blank_image = Image.new('RGBA', (400, 300), 'white')
# # 在 blank_image 图像上绘图
# img_draw = ImageDraw.Draw(blank_image)
# # 画一个矩形
# img_draw.rectangle((70, 50, 270, 200), outline='red', fill='blue')
# # 取得字形物件
# fnt = ImageFont.truetype('/System/Library/Fonts/Monaco.ttf', 40)
# # 放上文字信息到图像
# img_draw.text((70, 250), 'hello world', font=fnt, fill='green')

# # 产生一个有 4 个颜色 channels 的空白图像
# blank_image = Image.new('RGBA', (400, 300), 'white')
# # 在 blank_image 图像上绘图
# img_draw = ImageDraw.Draw(blank_image)
# # 在 PIL 中可以用 rectangle 来画一个四方形，但是无法控制框线的粗细
# img_draw.rectangle((70, 50, 270, 200), outline=None, fill='pink')
# # 通过画线来画一个四方框的框线并控制粗细
# img_draw.line([(70, 50), (270, 50), (270, 200), (70, 200), (70, 50)], fill='red', width=4)
# # 在 PIL 中要画一个可以控制大小的图要通过以下方式
# r = 10  # 设定半径
# # 以图的中心点(x, y)来计算框住图的边界框坐标[(x1, y1), (x2, y2)]
# img_draw.ellipse((270-r, 200-r, 270+r, 200+r), fill='orange')
# # 画一个多边形
# img_draw.polygon([(40, 40), (40, 80), (80, 60), (60, 40)], fill='green', outline=None)

# 颜色变换
# 将彩色的转换成灰阶
greyscale_image = image.convert('L')
# 注意要注明 cmap='gray' 才能正确 show 出灰阶图像

plt.imshow(greyscale_image, cmap='gray')
plt.show()
