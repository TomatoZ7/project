<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group(['namespace' => 'App\Http\Controllers\Upload'], function () {

    Route::post('upload', 'UploadController@upload');

    Route::post('upload/base64', 'UploadController@uploadBase64');

});

Route::group(['namespace' => 'App\Http\Controllers\Download',  "middleware" => ['throttle:download']], function () {

    Route::get('download', 'DownloadController@download');

});

Route::group(['namespace' => 'App\Http\Controllers\Admin'], function () {

    Route::put('user/{id}/avatar', 'UserController@updateUserAvatar');

});

Route::group(['namespace' => 'App\Http\Controllers\Test', 'middleware' => []], function () {

    Route::get('test', 'TestController@test');

    // ES
    Route::post('test/es', 'ESApiTestController@createIndexDoc');
    Route::get('test/es/{id}', 'ESApiTestController@getIndexDocumentById');
    Route::get('test/es', 'ESApiTestController@getIndexDocument');
    Route::delete('test/es/{id}', 'ESApiTestController@delete');
    // ES index
    Route::delete('test/es/index/{index_name}', 'ESApiTestController@deleteIndex');
    Route::post('test/es/index', 'ESApiTestController@createIndex');
    // ES demo
    Route::post('test/es/industry', 'ESApiTestController@genIndustryIndex');
    Route::get('test/es/industry/{keyword}', 'ESApiTestController@getIndustry');

    // Redis
    Route::get('test/redis', 'RedisTestController@test');
    Route::get('test/redis/transaction', 'RedisTestController@testTransaction');
    Route::get('test/redis/spike/{skuid}', 'RedisTestController@spike');
});

Route::group(['namespace' => 'App\Http\Controllers\Demo'], function () {
    Route::get('/posts/popular', 'PostController@popular');
    Route::get('/posts/{post}', 'PostController@show');
});
