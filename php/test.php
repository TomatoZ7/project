<?php


$path = "/Users/tz7/project/dnmp/www/zaker/rmt-shumei/storage/app/temp/180aac7fba864d31ce5969c25e138fb9.mp3";

$cmd_prefix = "ffmpeg -i";

try {

    $cmd_prefix = "ffmpeg -i";

    $cmd = $cmd_prefix . " {$path} -af silencedetect=n=-50dB:d=0.3 -f null - 2>&1";

    ob_start();
    passthru($cmd);
    $info = ob_get_contents();
    ob_end_clean();

    $silence_start_list = [];
    $silence_end_list = [];
    $info_arr = explode("[silencedetect @ ", $info);
    if (!empty($info_arr)) {
        foreach ($info_arr as $v) {
            $v = trim($v);
            if (strpos($v, "silence_start") !== false) {
                if (preg_match('/silence_start: (-?\d+\.\d+)/', $v, $match)) {
                    $silence_start_list[] = $match[1] ?? 0;
                }
            } elseif (strpos($v, "silence_end") !== false) {
                if (preg_match('/silence_end: (-?\d+\.\d+)/', $v, $match)) {
                    $silence_end_list[] = $match[1] ?? 0;
                }
            }
        }
    }

    var_dump($info, $silence_start_list, $silence_end_list);

    if (empty($silence_start_list) || empty($silence_end_list)) {
        throw new \Exception("识别不出静音数据");
    }

    $silence_start_last = end($silence_start_list);
    $silence_end_last = end($silence_end_list);
    // 结尾没有静音
    if ($silence_end_last <= '6.95') {
        throw new \Exception("结尾没有静音");
    }

    var_dump('ending');
//    return [1, 'success', []];

} catch (\Exception $e) {
    var_dump($e->getMessage());
//    return [0, $e->getMessage(), []];
}
