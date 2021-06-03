<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use App\Models\User;
use App\Utils\UploadUtil;
use function PHPUnit\Framework\isNull;

class UserController extends Controller
{
    /**
     * 修改用户头像
     */
    public function updateUserAvatar($id, UploadUtil $upload_util)
    {
        $user = User::find($id);
        if (is_null($user)) {
            throw new \Exception('user not found', 404);
        }

        $avatar_path = request()->input('avatar');
        $avatar_path = $upload_util->moveTmpFileToOfficialFile($avatar_path, 'user');

        if (empty($avatar_path)) {
            throw new \Exception('upload avatar fail', 500);
        }

        $user->avatar = $avatar_path;
        $user->save();

        return response()->json('success');
    }
}
