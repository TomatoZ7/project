<?php

namespace App\Utils;

use Illuminate\Support\Facades\File;
use Illuminate\Support\Str;

/**
 * Class UploadUtil
 * @package App\Utils
 *
 * 软链接:ln -s xxx/daily_laravel/storage/app/public/upload xxx/daily_laravel/public/upload
 */
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

    /**
     * 将临时文件copy到正式文件目录
     */
    public function moveTmpFileToOfficialFile($file_path, $module_name = 'official')
    {
        if (empty($file_path)) {
            return '';
        }

        if (file_exists(storage_path('app/storage/') . $file_path)) {
            return '';
        }

        if (strpos($file_path, 'upload/tmp') !== false) {
            $date = date('Ymd');
            $filename = substr($file_path, strrpos($file_path, '/') + 1);

            if (!is_dir(storage_path('app/public/') . "{$module_name}")) {
                mkdir(storage_path('app/public/') . "{$module_name}", 0777, true);
            }

            $file_tmp_path = storage_path('app/public/') . $file_path;
            $target_path = storage_path('app/public/') . "upload/{$module_name}/{$date}/{$filename}";

            File::copy($file_tmp_path, $target_path);

            return "{$module_name}/{$date}/{$filename}";
        }

        return $file_path;
    }

    /**
     * @param $img
     * @return false|string
     */
    public function getBase64Image($img)
    {
        try {

            $img_content = file_get_contents($img);
            $img_base64 = chunk_split(base64_encode($img_content));

            return $img_base64;

        }catch (\Exception $e) {
            return false;
        }
    }
}
