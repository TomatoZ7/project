<?php

namespace App\Http\Controllers\Download;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use function PHPUnit\Framework\fileExists;

class DownloadController extends Controller
{
    /**
     * 下载
     * @throws \Exception
     */
    public function download()
    {
        $url = request()->input('url');

        if (empty($url)) {
            throw new \Exception('file empty', 400);
        }

        $file_path = str_replace(config('app.url'), storage_path('app/public/'), $url);

        if (!fileExists($file_path)) {
            throw new \Exception('file not found', 404);
        }

        return response()->download($file_path);
    }
}
