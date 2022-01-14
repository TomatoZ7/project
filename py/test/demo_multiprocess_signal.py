import time
import json
import multiprocessing


class Work(object):
    def __init__(self, q):
        self.q = q

    def send(self, msg):
        if not isinstance(msg, str):
            msg = json.dumps(msg)

        self.q.put(msg)

    def send_all(self):
        for i in range(20):
            self.q.put(i)
            time.sleep(1)

    def receive(self):
        while True:
            result = self.q.get()
            try:
                res = json.loads(result)
            except:
                res = result
            print('recv is %s' % res)


if __name__ == '__main__':
    q = multiprocessing.Queue()
    work = Work(q)
    send = multiprocessing.Process(target=work.send, args=({'name': 'tz'},))
    recv = multiprocessing.Process(target=work.receive)
    send_all_process = multiprocessing.Process(target=work.send_all)

    send_all_process.start()
    send.start()
    recv.start()

    send_all_process.join()
    recv.terminate()
