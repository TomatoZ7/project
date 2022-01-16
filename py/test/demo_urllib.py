import urllib.request


def use_proxy(proxy_addr, url):
    proxy = urllib.request.ProxyHandler({'http': proxy_addr})
    opener = urllib.request.build_opener(proxy, urllib.request.HTTPHandler)
    urllib.request.install_opener(opener)
    data = urllib.request.urlopen(url).read().decode('utf-8')
    return data


def debug_log():
    httphd = urllib.request.HTTPHandler(debuglevel=1)
    httpshd = urllib.request.HTTPSHandler(debuglevel=1)
    opener = urllib.request.build_opener(httphd, httpshd)
    urllib.request.install_opener(opener)
    data = urllib.request.urlopen('http://edu.51cto.com')


if __name__ == "__main__":
    # proxy_addr = "202.75.210.45:7777"
    # data = use_proxy(proxy_addr, 'http://www.baidu.com')
    # print(len(data))

    debug_log()
