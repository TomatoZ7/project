import numpy as np
import matplotlib.pyplot as plt
import matplotlib.mlab as mlab

# X = [0, 1, 2, 3, 4, 5]
# Y = [222, 42, 52, 212, 123, 111]
#
# fig = plt.figure()
# plt.bar(X, Y, 0.4, color="green")
# plt.xlabel("X-axis")
# plt.ylabel("Y-axis")
# plt.title("bar chart")
#
# plt.show()

# # 准备数据
# data = [[30, 25, 50, 20],
#         [40, 23, 51, 17],
#         [35, 22, 45, 19]]
# X = np.arange(4)
# fig = plt.figure()
# # 添加子图区域
# ax = fig.add_axes([0, 0, 1, 1])
#
# ax.plot(X, np.exp(X))
# ax.plot(X, X**2)
#
# # 绘制柱状图
# ax.bar(X + 0.00, data[0], color='b', width=0.25)
# ax.bar(X + 0.25, data[1], color='g', width=0.50)
# ax.bar(X + 0.50, data[2], color='r', width=0.75)
#
# plt.show()

import math

x = np.array([1, 2, 3])
y = np.array([1.2, 2.4, 3.6])
# 生成画布对象
fig = plt.figure()
# 添加绘图区域
ax = fig.add_axes([0.1, 0.1, 0.8, 0.8])
ax.plot(x, y)

# 设置x轴标签
ax.set_xticks([1, 2, 3])
# 设置x轴刻度标签
ax.set_xticklabels(['Left', 'Mid', 'Right'])
# 设置y轴刻度
ax.set_yticks([0, 1, 2, 3, 4])
# 设置 y 轴刻度标签
ax.set_yticklabels([0, -1, -2, -3, -4])

plt.show()

# if __name__ == '__main__':
#     X1 = np.arange(4)
#     X2 = [1,2,3,50]
#     X3 = np.array(X2)
#     print(type(X1), type(X3))
