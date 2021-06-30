<?php

namespace App\Http\Controllers\Demo;

use App\Http\Controllers\Controller;
use App\Jobs\PostViewsIncrement;
use App\Models\Post;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redis;

class PostController extends Controller
{
    public function show(Post $post)
    {
        $post->increment('views');
        if ($post->save()) {
            // 将当前文章浏览数 +1，存储到对应 Sorted Set 的 score 字段
//            Redis::zincrby('popular_posts', 1, $post->id);
            Redis::lpush('post-views-increment', $post->id);
        }
        return 'Show Post #' . $post->id;
    }

    // 获取热门文章排行榜
    public function popular()
    {
        // 获取浏览器最多的前十篇文章
        $postIds = Redis::zrevrange('popular_posts', 0, 9);
        if ($postIds) {
            $idsStr = implode(',', $postIds);
            // 查询结果排序必须和传入时的 ID 排序一致
            $posts = Post::whereIn('id', $postIds)
                ->select(['id', 'title', 'views'])
                ->orderByRaw('field(`id`, ' . $idsStr . ')')
                // ->whereIn('id', $postIds)
                // ->orderBy('views')
                ->get();
        } else {
            $posts = null;
        }

        dd($posts->toArray());

        return response()->json($posts);
    }

    // 浏览文章(队列)
    public function showOfQueue($id)
    {
        $post = Post::query()->find($id);

        $this->dispatch(new PostViewsIncrement($post));
        return "Show Post #{$post->id}, Views: {$post->views}";
    }
}
