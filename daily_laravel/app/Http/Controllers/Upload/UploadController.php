<?php

namespace App\Http\Controllers\Upload;

use App\Http\Controllers\Controller;
use App\Utils\UploadUtil;
use Illuminate\Http\Request;

class UploadController extends Controller
{
    /**
     * 上传
     */
    public function upload(UploadUtil $upload_util)
    {
        $file = request()->file('file');

        if (empty($file)) {
            throw new \Exception("please upload the file first", 400);
        }

        $tmp_path = $upload_util->uploadToTmp($file);

        $response = [
            'message' => '上传成功',
            'data' => [
                'relative_path' => $tmp_path,
                'access_url' => $upload_util->getAccessUrlByRelativePath($tmp_path),
                'mime_type' => $file->getClientMimeType(),
            ]
        ];

        return response()->json($response);
    }
}
