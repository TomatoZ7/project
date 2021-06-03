<?php

namespace App\Utils;

use Illuminate\Support\Str;

class UploadUtil
{
    /**
     * 将上传的图片存至本地，返回相对路径
     *
     * TODO 能否判断文件内容一致?
     */
    public function uploadToTmp($file)
    {
        if (empty($file)) {
            return '';
        }

        $file_extension = $file->getClientOriginalExtension();
        $new_filename = Str::random(32) . ".{$file_extension}";

        $date = date('Ymd');
        $file->move(storage_path("app/public/upload/tmp/{$date}"), $new_filename);

        return "upload/tmp/{$date}/{$new_filename}";
    }

    /**
     * 根据相对路径获取访问路径
     */
    public function getAccessUrlByRelativePath($relative_path)
    {
        if (empty($relative_path)) {
            return '';
        }

        if (strpos($relative_path, 'http') !== false) {
            return $relative_path;
        }

        if (strpos($relative_path, 'upload') !== false) {
            if (strpos($relative_path, '/') === 0) {
                return config('app.url') . $relative_path;
            }
            return config('app.url') . '/' . $relative_path;
        }

        return $relative_path;
    }
}
