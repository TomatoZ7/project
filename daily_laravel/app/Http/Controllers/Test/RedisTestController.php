<?php


namespace App\Http\Controllers\Test;
use Illuminate\Support\Facades\Redis;


class RedisTestController
{
    public function test()
    {
        $redis = Redis::connection()->client();

        $result =
//              $redis->ping();
//              $redis->flushDB();
//              $redis->exists("money");
//              $redis->mset(["key1"=>"value1", "key2"=>"value2", "key3"=>"value3"]);
              $redis->mget(['key1', 'key2']);

        dd($result);
    }

    public function testTransaction()
    {
        $redis = Redis::connection()->client();

        try {
            $multi = $redis->multi();
            $multi->flushDB();
            $multi->set('key1', 'value1');
            $multi->set('key2', 'value2');
            $multi->exec();
        }catch (\Exception $e) {
            $redis->discard();
        } finally {
            echo $redis->get('key1');
            echo $redis->get('key2');
        }
    }
}
