# -*- coding: utf-8 -*-

import os
import time
import random
import threading
from concurrent.futures import ThreadPoolExecutor

lists = ['python', 'django', 'tornado', 'flask', 'bs5', 'requests', 'uvloop']
new_lists = []


def run_thread_work():
    if len(lists) == 0:
        return
    data = random.choice(lists)
    lists.remove(data)
    new_data = '%s_new' % data
    new_lists.append(new_data)
    time.sleep(1)


def run_thread():
    start = time.time()
    print('old list len:', len(lists))
    t_list = []
    for i in range(len(lists)):
        t = threading.Thread(target=run_thread_work)
        t_list.append(t)
        t.start()

    for t in t_list:
        t.join()

    print('old list:', lists)
    print('new list:', new_lists)
    print('new_list len', len(new_lists))
    print('time is %s' % (time.time() - start))


def run_thread_pool_work(i):
    # lock.acquire()
    print(i, os.getpid())
    time.sleep(1)
    # lock.release()
    return 'result %s' % i


def run_thread_pool():
    print(os.getpid())
    t = ThreadPoolExecutor(2)
    result = []
    for i in range(20):
        t_result = t.submit(run_thread_pool_work, (i, ))
        result.append(t_result)

    for res in result:
        print(res.result())


if __name__ == "__main__":
    # run_thread()
    run_thread_pool()
