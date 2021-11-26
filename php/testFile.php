<?php

try {

    $file = fopen('./test.txt', 'r');
//echo fwrite($file, '你好，世界', 3);
//    while (!feof($file)) {
//        $c = fgetc($file);
//        echo($c);
//    }
    echo fread($file, 3);
    fclose($file);

} catch (\Throwable $throwable) {
    var_dump($throwable);
}