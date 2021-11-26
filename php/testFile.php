<?php

try {

    $file = fopen('./test.txt', 'r');
//echo fwrite($file, '你好，世界', 3);
     var_dump(fgetc($file));
    fclose($file);

} catch (\Throwable $throwable) {
    var_dump($throwable);
}