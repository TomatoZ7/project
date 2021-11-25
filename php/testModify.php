<?php

require_once dirname(__FILE__) . '/module/PHPExcel/PHPExcel/IOFactory.php';

try {

    // 文件路径
    $file_path = dirname(__FILE__) . '/module/PHPExcel/test.xlsx';

    if (!file_exists($file_path)) {
        var_dump('file not exist');
        die;
    }

    $obj_excel = PHPExcel_IOFactory::load($file_path);

    $sheet = $obj_excel->getSheet(0); // 读取第一個工作表
    $column_total = $sheet->getHighestColumn(); // 取得总列数
    $row_total = $sheet->getHighestRow(); // 取得总行数

    /**
     * 循环读取每个单元格的数据
     * row 是从 0 开始， column 是从 1 开始
     */
    for ($row=1;$row<=$row_total;$row++) {
        $first_column = $sheet->getCellByColumnAndRow(0, $row)->getValue();
        $second_column = $sheet->getCellByColumnAndRow(1, $row)->getValue();

        $sheet->setCellValueByColumnAndRow(2, $row, $first_column + $second_column);
    }

    $obj_excel->getActiveSheet()->setTitle('tz');
    $obj_excel->setActiveSheetIndex(0);

    /** 输出到指定目录 */
    $obj_writer = PHPExcel_IOFactory::createWriter($obj_excel, 'Excel2007');
    $obj_writer->save(dirname(__FILE__) . '/module/PHPExcel/test.xlsx');

} catch (\Exception $e) {
    var_dump($e->getLine() . ':' . $e->getMessage());
}