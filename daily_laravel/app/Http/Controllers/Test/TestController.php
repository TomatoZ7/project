<?php

namespace App\Http\Controllers\Test;

use App\Events\ESIndustryEvent;
use App\Http\Controllers\Controller;
use Elasticsearch\ClientBuilder;

class TestController extends Controller
{
    /**
     * 测试
     */
    public function test()
    {
        echo "<h1>Hello Laravel</h1>";
    }
}
