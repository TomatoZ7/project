<?php

namespace App\Http\Controllers\Test;

use App\Http\Controllers\Controller;

class TestController extends Controller
{
    /**
     * 测试
     */
    public function test()
    {
        // dd(env('ES_HOSTS'));

        dd(app('es')->info());
    }
}
