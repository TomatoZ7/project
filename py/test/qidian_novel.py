"""
利用 Requests 和 Lxml 第三方库，爬取起点中文网小说信息，运用 xlwt 库存储为 Excel 格式
爬取的信息有：小说名，作者、小说类型、完成情况、摘要和字数
"""
import time
import requests
import os
import xlwt
from lxml import etree

path = os.path.split(os.path.realpath(__file__))[0]

# 初始化小说列表
novel_list = []


def get_info(url):
    html = requests.get(url)
    selector = etree.HTML(html.text)

    novel_containers = selector.xpath('//div[@class="book-img-text"]/ul/li')
    for container in novel_containers:
        name = container.xpath('div/h2/a/text()')[0]
        author = container.xpath('div/p[@class="author"]/a[1]/text()')[0]
        novel_type = container.xpath('div/p[@class="author"]/a[2]/text()')[0]
        novel_sub_type = container.xpath('div/p[@class="author"]/a[3]/text()')[0]
        finish_type = container.xpath('div/p[@class="author"]/span/text()')[0]
        introduction = container.xpath('div/p[@class="intro"]/text()')[0].strip()
        # word_num = container.xpath('div/p[@class="update"]/span/text()')
        novel_list.append([name, author, novel_type, novel_sub_type, finish_type, introduction])


if __name__ == '__main__':
    urls = ['https://www.qidian.com/all/page{}/'.format(page) for page in range(1, 6)]

    for url in urls:
        get_info(url)
        time.sleep(1)

    # 创建表格
    book = xlwt.Workbook(encoding='utf-8')
    # 创建 sheet
    sheet = book.add_sheet('起点小说')
    # 列宽
    for i in range(0, 6):
        column = sheet.col(i)
        column.width = 256*20
    # 表头
    header = ['小说名', '作者', '大类', '子类', '状态', '简介']
    for h in range(len(header)):
        sheet.write(0, h, header[h])
    # 内容
    row = 1
    for novel in novel_list:
        col = 0
        for data in novel:
            sheet.write(row, col, data)
            col += 1
        row += 1
    # 保存
    book.save(path + '/data/qidian_novel.xls')
