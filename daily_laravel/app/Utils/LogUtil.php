<?php


namespace App\Utils;

use Illuminate\Support\Facades\Log;

class LogUtil
{
    /**
     * 打印请求信息
     */
    public static function logRequest($request)
    {
        $log = [
            'ip' => $_SERVER['HTTP_X_FORWARDED_FOR'] ?? $request->getClientIp(),
            'port' => $request->getPort(),
        ];

        Log::info(json_encode($log));
    }
}
