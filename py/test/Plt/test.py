import numpy as np
import matplotlib.pyplot as plt
import matplotlib.mlab as mlab


# x = np.array([1, 2, 3])
# y = np.array([2, 3, 4])
# # 生成画布对象
# fig = plt.figure()
# # 添加绘图区域
# ax = fig.add_axes([0.1, 0.1, 0.8, 0.8])
# ax.plot(x, y)
#
# # 设置x轴标签
# ax.set_xticks([0, 0.5, 1.5])
# # 设置x轴刻度标签
# ax.set_xticklabels(['', 'Left', 'Right'])
# # 设置y轴刻度
# ax.set_yticks([0, 1, 2, 3, 4])
# # 设置 y 轴刻度标签
# ax.set_yticklabels([0, -1, -2, -3, -4])
#
# ax.annotate()
#
# plt.show()

# x = np.linspace(-3, 3, 50)
# y1 = 2*x+1
# y2 = x**2

# 创建图像
fig = plt.figure()

# x = np.array([-350, -300, -250, -200, -150, -100, -50, 0, 50, 100, 150, 200, 250, 300])
# y1 = np.array([6, 10, 4, 4, 15, 9, -5, 13, -2, 12, 3, 2, 15, -5])
# y2 = np.array([9, -8, -3, 8, -8, 12, 0, -2, 11, -1, -6, 1, -3, 5])

x = np.linspace(-350, 300, 300)
y1 = np.random.randint(-350, 300, 300)
y2 = np.random.randint(-350, 300, 300)

plt.plot(x, y1)
plt.plot(x, y2)
plt.grid(True, linestyle="--")
#
# # 显示图片
plt.show()

# if __name__ == '__main__':
#     x = np.random.randint(-8, 16, [1, 14])
#
#     print(x)


