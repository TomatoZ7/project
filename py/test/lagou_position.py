"""
爬取拉勾网招聘的信息，并存储在 MongoDB
"""

import requests
import json
import time
import math
from Utils.PyMongoUtil import db_test

# Mongo 集合
collection = db_test['lagou_position_python']

headers = {
    'Cookie': 'JSESSIONID=ABAAABAABEIABCI08110DD794798E2AE3E4CDCEEBFC2068; '
              'WEBTJ-ID=20211226214508-17df6fce47ac61-0d3a66744a09b5-36657407-1484784-17df6fce47b178b; '
              'RECOMMEND_TIP=true; privacyPolicyPopup=false; PRE_UTM=; PRE_HOST=; '
              'PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; '
              'user_trace_token=20211226214511-08ad3aa4-22b4-4ea4-a40d-650ec122b61e; '
              'LGSID=20211226214511-40a20b81-7d1c-442e-9f18-3d275b38714b; PRE_SITE=; '
              'LGUID=20211226214511-9b2251f0-f11e-4d83-9ff9-8c20e426a37f; _ga=GA1.2.1013706532.1640526311; '
              'Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1640526311; _gid=GA1.2.1783909427.1640526312; '
              'sajssdk_2015_cross_new_user=1; sensorsdata2015session=%7B%7D; index_location_city=%E5%85%A8%E5%9B%BD; '
              'TG-TRACK-CODE=index_search; X_HTTP_TOKEN=1dfa6066b340c3b401362504615d7fd6d7a7119d50; '
              'Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1640527711; '
              'LGRID=20211226220831-a16b4cd1-ef12-47b7-872a-3d74359da633; '
              'sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217df6fd0f84283-00db462af9c719-36657407-1484784'
              '-17df6fd0f8510a7%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22'
              '%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96'
              '%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%2C%22'
              '%24os%22%3A%22MacOS%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2296.0.4664.110'
              '%22%7D%2C%22%24device_id%22%3A%2217df6fd0f84283-00db462af9c719-36657407-1484784-17df6fd0f8510a7%22%7D ',
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/96.0.4664.110 Safari/537.36 ',
    'Connection': 'keep-alive'
}


# 获取总记录数计算分了多少页
def get_page(url, param):
    response = requests.post(url, data=param, headers=headers)
    response_data = json.loads(response.text)

    total = response_data['content']['positionResult']['totalCount']
    page_size = response_data['content']['pageSize']
    page_num = math.ceil(total / page_size)

    return page_num


# 获取招聘信息
def get_position(url, param):
    try:

        response = requests.post(url, data=param, headers=headers)
        response_data = json.loads(response.text)
        results = response_data['content']['positionResult']['result']

        for result in results:
            info = {
                # 职位关键字
                'position_keyword': 'python',
                # 城市
                'city': param['city'] if param['city'] else '',
                # 职位名称
                'position_name': result['positionName'],
                # 职位工资
                'position_salary': result['salary'],
                # 职位N薪
                'position_salary_month': result['salaryMonth'] if result['salary'] else '12',
                # 职位要求工作年限
                'position_work_year': result['workYear'],
                # 工作地址
                'position_address': result['positionAddress'],
                # 职位详情
                'position_detail': result['positionDetail'],
                # 公司名
                'company_name': result['companyFullName'],
                # 公司规模
                'company_size': result['companySize'],
                # 公司标签
                'company_label': result['companyLabelList']
            }

            collection.insert_one(info)

    except requests.exceptions.ConnectionError:
        print('请求失败：' + url)


if __name__ == '__main__':
    request_url = 'https://www.lagou.com/jobs/v2/positionAjax.json'

    cities = ['广州', '深圳']

    for city in cities:
        params = {
            'first': 'true',
            'needAddtionalResult': 'false',
            'city': city,
            'px': 'new',
            'pn': '1',
            'fromSearch': 'true',
            'kd': 'Python'
        }

        page_num = get_page(request_url, params)
        if page_num > 0:
            for num in range(1, page_num):
                params['pn'] = str(num)
                get_position(request_url, params)
                time.sleep(5)
