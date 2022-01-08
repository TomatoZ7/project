<?php

class BinaryConversionUtil
{
    private static $dict_62 = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

    /**
     * 10 进制转 62 进制
     *
     * @param int $num
     * @return string
     */
    public static function from10_to62(int $num): string
    {
        $conversion = 62;
        $res = '';

        do {
            $res = self::$dict_62[bcmod($num, $conversion)] . $res;
            $num = bcdiv($num, $conversion);
        } while ($num > 0);

        return $res;
    }

    /**
     * 62 进制转 10 进制
     *
     * @param string $str
     * @return int|string
     */
    public static function from62_to10(string $str)
    {
        $from = 62;
        $len = strlen($str);
        $dec = 0;

        for ($i = 0; $i < $len; $i++) {
            $pos = strpos(self::$dict_62, $str[$i]);
            $dec = bcadd(bcmul(bcpow($from, $len - $i - 1), $pos), $dec);
        }

        return $dec;
    }
}