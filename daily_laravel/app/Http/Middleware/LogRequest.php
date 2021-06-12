<?php

namespace App\Http\Middleware;

use App\Utils\LogUtil;
use Closure;
use Illuminate\Http\Request;

class LogRequest
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle(Request $request, Closure $next)
    {
        LogUtil::logRequest($request);

        return $next($request);
    }
}
