import re
import time
import urllib.request
import urllib.error

headers = ("User-Agent",
           "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 "
           "Safari/537.36")

opener = urllib.request.build_opener()
opener.addheaders = [headers]
# 将 opener 安装为全局
urllib.request.install_opener(opener)
# 文章链接
article_link_list = []


# 使用代理
def use_proxy(proxy_addr, url):
    try:
        proxy = urllib.request.ProxyHandler({'http': proxy_addr})
        opener = urllib.request.build_opener(proxy, urllib.request.HTTPHandler)
        urllib.request.install_opener(opener)
        data = urllib.request.urlopen(url).read().decode('utf-8')
        return data
    except urllib.error.URLError as e:
        if hasattr(e, 'code'):
            print(e.code)
        if hasattr(e, 'reason'):
            print(e.reason)
        time.sleep(10)
    except Exception as e:
        print('exception' + str(e))
        time.sleep(1)


# 获取所有文章链接
def getlisturl(key, page_start, page_end, proxy):
    try:
        page = page_start
        # 编码关键词 key
        keycode = urllib.request.quote(key)
        # 编码 &page
        page_code = urllib.request.quote('&page')
        # 循环爬取各页的文章链接
        for page in range(page_start, page_end + 1):
            # 分别构建各页的 url 链接，每次循环构建一次
            url = "http://weixin.sogou.com/weixin?type=2&query=" + keycode + page_code + str(page)
            # 用代理服务器爬取，解决 IP 被封杀问题
            data = use_proxy(proxy, url)
            # 获取文章链接的正则表达式
            link_pattern = '<div class="txt-box">.*?(http://.*?)'
            # 获取每页的所有文章链接并添加到列表 article_link_list 中
            article_link_list.append(re.compile(link_pattern, re.S).findall(data))
            print('共获取到' + str(len(article_link_list)) + '页')
            return article_link_list
    except urllib.error.URLError as e:
        pass
