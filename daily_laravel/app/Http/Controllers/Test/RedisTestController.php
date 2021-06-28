<?php


namespace App\Http\Controllers\Test;
use App\Utils\LogUtil;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Redis;
use Illuminate\Support\Str;

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

        // 1、拼接 redis key
        $sku_key = 'sk:' . $skuid . ':qt';

        $user_id = Str::random(5);
        $user_key = 'sk:' . $skuid . ':user';

        // 2、商品是否处于秒杀阶段
        if (!$redis->exists($sku_key)) {
            return response()->json('秒杀还未开始！');
        }

        // 3、判断用户是否重复秒杀
        if ($redis->sIsMember($user_key, $user_id)) {
            Log::info("{$user_id} 重复参与秒杀。");
            return response()->json('已经参与秒杀！');
        }

        // 4、商品库存
        if ($redis->get($sku_key) < 1) {
            Log::info("{$user_id} 秒杀已经结束。");
            return response()->json('秒杀已经结束！');
        }

        // 5、秒杀
        try {

            $redis->decr($sku_key);
            $redis->sAdd($user_key, $user_id);

            return response()->json('恭喜你成功抢到商品！');

        }catch (\Exception $e) {
            Log::error("{$user_id} " . $e->getMessage());
            return response()->json($e->getMessage());
        }
    }
}
