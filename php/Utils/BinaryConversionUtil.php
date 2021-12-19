<?php

class BinaryConversionUtil
{
    /**
     * 10 进制转 62 进制
     *
     * @param int $num
     * @return string
     */
    public static function from10_to64(int $num): string
    {
        $conversion = 62;
        $dict = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        $res = '';

        do {
            $res = $dict[bcmod($num, $conversion)] . $res;
            $num = bcdiv($num, $conversion);
        } while ($num > 0);

        return $res;
    }

    public static function from64_to10(string $str)
    {

    }
}

$res = BinaryConversionUtil::from10_to64(62);
var_dump($res);
