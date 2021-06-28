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
    
    /**
     * @params $skuid
     * 
     * 模拟秒杀
     */
    public function spike($skuid)
    {
        $redis = Redis::connection()->client();
        
        $sku_key = 'spike' . $skuid;
        
        // 1、商品是否处于秒杀阶段
        if (!$redis->exists($sku_key)) {
            return response()->json('the spike hasn\'t started yet');
        }
        
        // 2、商品库存
        if ($redis->get($sku_key)) {
            return response()->json('the spike is over');
        }
    }
}
