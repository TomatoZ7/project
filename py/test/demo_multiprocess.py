import multiprocessing
import time
import os


def work_a():
    for i in range(10):
        print(i, 'a', os.getpid())
        time.sleep(1)


def work_b():
    for i in range(10):
        print(i, 'b', os.getpid())
        time.sleep(1)


def double_process():
    start = time.time()

    process_a = multiprocessing.Process(target=work_a)  # 子进程 1
    process_b = multiprocessing.Process(target=work_b)  # 子进程 1

    for p in (process_a, process_b):
        p.start()  # 执行进程

    for p in (process_a, process_b):
        p.join()  # 阻塞进程

    for p in (process_a, process_b):
        print(p.is_alive())

    print('总耗时：', time.time() - start)
    print('ppid is %s' % os.getpid())  # 主进程ID


def work(count, lock):
    lock.acquire()  # 上锁
    print(count, os.getpid())
    time.sleep(5)
    lock.release()  # 解锁
    return 'result is %s, pid is %s' % (count, os.getpid())


def pool_process():
    pool = multiprocessing.Pool(5)
    manger = multiprocessing.Manager()
    lock = manger.Lock()
    for i in range(20):
        result = pool.apply_async(func=work, args=(i, lock))  # 任务加入进程池
        # print(result)

    pool.close()  # 关闭进程池
    pool.join()  # 等待进程池任务结束


if __name__ == '__main__':
    pool_process()
