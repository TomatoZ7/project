from bs4 import BeautifulSoup
import requests
import time

'''
标题、地址、价格、房东名称、房东性别和房东头像的链接
'''

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 '
                  'Safari/537.36 '
}


# 判断 gender
def judgment_gender(class_name):
    if class_name == ['member_icon']:
        return '女'
    else:
        return '男'


# 获取详细页 URL
def get_links(url):
    wb_data = requests.get(url, headers=headers)
    soup = BeautifulSoup(wb_data.text, 'lxml')
    links = soup.select('#page_list > ul > li > a')
    for link in links:
        href = link.get('href')
        get_info(href)


# 获取网页信息
def get_info(url):
    wb_data = requests.get(url)
    soup = BeautifulSoup(wb_data, 'lxml')
    titles = soup.select('div.pho_info > h4')
    addresses = soup.select('span.pr5')
    prices = soup.select('#pricePart > div.day_1 > span')
    imgs = soup.select('#floatRightBox>div.js_box.clearfix > div.member_pic > a > img')
    names = soup.select('#floatRightBox > div.js_box.clearfix > div.w_240 > h6 > a')
    genders = soup.select('#floatRightBox > div.js_box.clearfix > div.member_pic > div')

    for title, address, price, img, name, gender in zip(titles, addresses, prices, imgs, names, genders):
        data = {
            'title': title.get_text().strip(),
            'address': address.get_text().strip(),
            'price': price.get_text(),
            'img': img.get('src'),
            'name': name.get_text(),
            'gender': judgment_gender(gender.get('class'))
        }

        print(data)


if __name__ == '__main__':
    urls = ['http://bj.xiaozhu.com/search-duanzufang-p{}-0/'.format(number) for number in range(1, 14)]

    for url in urls:
        get_links(url)
        time.sleep(2)
