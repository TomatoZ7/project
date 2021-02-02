package com.cbh.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cbh.domain.Book;
import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;
import com.cbh.service.BookService;
import com.cbh.service.CategoryService;
import com.cbh.utils.ImportResult;
import com.cbh.utils.Result;

@RequestMapping(value = "/book")
@RestController
public class BookController {
	@Autowired
	BookService bookservice;
	@Autowired
    CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<?,?> index(Integer offset, Integer limit, Integer first_category_id, Integer second_category_id, 
			String book_name, Integer status, String content) {

		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("first_category_id", first_category_id);
		param.put("second_category_id", second_category_id);
		param.put("book_name", book_name);
		param.put("status", status);
		param.put("content", content);
		
		List<List<?>> list = bookservice.getBookList(param);
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Book getBookByid(@PathVariable int id) {
		Book book = bookservice.getBookById(id);
        if (book == null) {
        	return new Book();
        }
        return book;
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result insertBook(@RequestBody Book book) {
		// 设置创建时间
    	book.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
    	int result = bookservice.insertBook(book);
        if (result == 0) {
        	return new Result(403, "添加失败。");
        }

        return new Result(200, "添加成功。");
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Result updateBook(@PathVariable int id, @RequestBody Book book){
		book.setId(id);
    	
        int result = bookservice.updateBook(book);
        if (result == 0) {
        	return new Result(403, "更新失败。");
        }

        return new Result(200, "更新成功。");
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delBookById(@PathVariable int id) {
        int res = bookservice.delBookById(id);
        if (res == 0) {
        	return new Result(403, "删除失败");
        }

        return new Result(200, "删除成功");
    }
	
	/**
	 * 模板导出
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/template")
	public void excel(HttpServletResponse response) throws IOException {
		// 数据初始化
		List<firstCategory> listCate = categoryService.getCategory();
		List<String> firstCateList = new ArrayList<String>();
		Map<String, List<String>> secondCateMap = new HashMap<String, List<String>>();
		// 封装数据
		for (firstCategory category : listCate) {
			firstCateList.add("C" + category.getId() + "_" + category.getCategory_name());
			
			List<String> secondCateList = new ArrayList<String>();
			List<Category> secondCate = category.getSecond_cate();
			for (Category child : secondCate) {
				secondCateList.add("C" + child.getId() + "_" + child.getCategory_name());
			}
			secondCateMap.put("C" + category.getId() + "_" + category.getCategory_name(), secondCateList);
		}
		
		response.setCharacterEncoding("UTF-8");
		//创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("书籍模板");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("书籍名称");
        titleRow.createCell(1).setCellValue("一级分类");
        titleRow.createCell(2).setCellValue("二级分类");
        titleRow.createCell(3).setCellValue("馆藏量");
        titleRow.createCell(4).setCellValue("书籍编码");
        titleRow.createCell(5).setCellValue("书籍位置");
        titleRow.createCell(6).setCellValue("书籍简介");
        // 隐藏sheet，用于隐藏分类数据
        HSSFSheet cateSheet = wb.createSheet("cateSheet");
        // 设置sheet是否隐藏 true:隐藏/false:显示
        wb.setSheetHidden(wb.getSheetIndex(cateSheet), false);
        // 写入数据
        writeData(wb, cateSheet, firstCateList, secondCateMap);
        // 设置数据有效性 
        setDataValid(wb, sheet, firstCateList, secondCateMap);
        
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("书籍模板".getBytes(),"iso-8859-1") + ".xls");
        
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        wb.close();
	}
	
	public static void writeData(HSSFWorkbook hssfWorkBook, HSSFSheet cateSheet, List<String> firstCateList, Map<String, List<String>> secondCateMap) {
		//循环将分类数据写入 cateSheet 的第1行中
		int cateRowId = 0;
		HSSFRow firstCateRow = cateSheet.createRow(cateRowId++);
		firstCateRow.createCell(0).setCellValue("分类列表");
		for (int i = 0; i < firstCateList.size(); i++) {
			firstCateRow.createCell(i + 1).setCellValue(firstCateList.get(i));
		}
		// 将具体的数据写入到每一行中，行开头为父级区域，后面是子区域。
		Iterator<String> keyIterator = secondCateMap.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			List<String> son = secondCateMap.get(key);
			HSSFRow cateRow = cateSheet.createRow(cateRowId++);
			cateRow.createCell(0).setCellValue(key);
			for (int i = 0; i < son.size(); i++) {
				cateRow.createCell(i + 1).setCellValue(son.get(i));
			}
			
			// 添加名称管理器
			String range = getRange(1, cateRowId, son.size());
			Name name = hssfWorkBook.createName();
			name.setNameName(key);
			String formula = cateSheet.getSheetName() + "!" + range;
			name.setRefersToFormula(formula);
		}
	}
	
	public static String getRange(int offset, int rowId, int colCount) {
		char start = (char) ('A' + offset);
		if (colCount <= 25) {
			char end = (char) (start + colCount - 1);
			return "$" + start + "$" + rowId + ":$" + end + "$" + rowId;
		} else {
			char endPrefix = 'A';
			char endSuffix = 'A';
			if ((colCount - 25) / 26 == 0 || colCount == 51) {// 26-51之间，包括边界（仅两次字母表计算）
				if ((colCount - 25) % 26 == 0) {// 边界值
					endSuffix = (char) ('A' + 25);
				} else {
					endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
				}
			} else {// 51以上
				if ((colCount - 25) % 26 == 0) {
					endSuffix = (char) ('A' + 25);
					endPrefix = (char) (endPrefix + (colCount - 25) / 26 - 1);
				} else {
					endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
					endPrefix = (char) (endPrefix + (colCount - 25) / 26);
				}
			}
			return "$" + start + "$" + rowId + ":$" + endPrefix + endSuffix + "$" + rowId;
		}
	}
	
	public static void setDataValid(HSSFWorkbook HSSFWorkBook, HSSFSheet sheet, List<String> firstCateList, Map<String, List<String>> secondCateMap) {
		//设置一级分类下拉
		HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper((HSSFSheet) sheet);
		DataValidationConstraint cateConstraint = dvHelper.createExplicitListConstraint(firstCateList.toArray(new String[] {}));
		CellRangeAddressList cateRangeAddressList = new CellRangeAddressList(1, 100, 1, 1);//意思是从B2：B101 为下拉
		DataValidation cateDataValidation = dvHelper.createValidation(cateConstraint, cateRangeAddressList);
		cateDataValidation.createErrorBox("error", "请选择正确的分类");
		cateDataValidation.setShowErrorBox(true);
		sheet.addValidationData(cateDataValidation);
		
		// 设置二级分类下拉
		for (int i = 0; i <= 100; i++) {
			// "B"是指 一级分类 所在的列，i+1初始值为1代表从第2行开始，2要与“B”对应，为B的列号加1，假如第一个参数为“C”，那么最后一个参数就2
			setDataValidation('B', sheet, i + 1, 2);
		}
	}
	
	public static void setDataValidation(char offset, HSSFSheet sheet, int rowNum, int colNum) {
		HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper(sheet);
		DataValidation dataValidationList1;
		dataValidationList1 = getDataValidationByFormula("INDIRECT($" + offset + (rowNum) + ")", rowNum, colNum, dvHelper);
		sheet.addValidationData(dataValidationList1);
	}
	
	private static DataValidation getDataValidationByFormula(String formulaString, int naturalRowIndex, int naturalColumnIndex, HSSFDataValidationHelper dvHelper) {
		DataValidationConstraint dvConstraint = dvHelper.createFormulaListConstraint(formulaString);
		CellRangeAddressList regions = new CellRangeAddressList(naturalRowIndex, 65535, naturalColumnIndex, naturalColumnIndex);
		HSSFDataValidation data_validation_list = (HSSFDataValidation) dvHelper.createValidation(dvConstraint, regions);
		data_validation_list.setEmptyCellAllowed(false);
		if (data_validation_list instanceof HSSFDataValidation) {
			// data_validation_list.setSuppressDropDownArrow(true);
			data_validation_list.setShowErrorBox(true);
		} else {
			// data_validation_list.setSuppressDropDownArrow(false);
		}
		// 设置输入信息提示信息
		data_validation_list.createPromptBox("下拉选择提示", "请使用下拉方式选择合适的值！");
		return data_validation_list;
	}
	
	/**
	 * 批量导入
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public ImportResult importBook(@RequestBody MultipartFile file) throws IOException, ParseException {
		// 导入成功标识符
		List<Map<String,Object>> errData = new ArrayList<Map<String,Object>>();
		ImportResult res = new ImportResult(403, "表格为空", 0, 0, errData);
		// 判断表格是不是空的
		if (file.getSize() == 0) {
			return res;
		}
		//得到文件的名称
		String fileName = file.getOriginalFilename();
		//获取文件的后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// 初始化时间
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		List<Book> listBook = new ArrayList<>();
		
		if ( suffix.equals(".xls") ) {
			// 建立Excel对象
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
			// 默认 获取Excel中的sheet1
			HSSFSheet sheet = workbook.getSheetAt(0);
			// 获取行的数量
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			if (physicalNumberOfRows <= 1) {
				workbook.close();
				return res;
			}else if ( physicalNumberOfRows > 101 ) {
				workbook.close();
				res.setMessage("表格行数不得大于100行");
				return res;
			}
			// 有标题则第一行不进行加载
			a:for (int j = 1; j < physicalNumberOfRows; j++) {
				// 获取该行的数据信息
				HSSFRow row = sheet.getRow(j);
				// 设置 cell type
				row.getCell(3).setCellType(CellType.STRING);
				// 每一行错误信息收集
				Map<String, Object> errRowData = new HashMap<String, Object>();
				errRowData.put("bookName", row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue());
				errRowData.put("firstCate", row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue());
				errRowData.put("SecondCate", row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue());
				errRowData.put("stock", row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue());
				errRowData.put("code", row.getCell(4) == null ? "" : row.getCell(4).getStringCellValue());
				errRowData.put("place", row.getCell(5) == null ? "" : row.getCell(5).getStringCellValue());
				errRowData.put("introduction", row.getCell(6) == null ? "" : row.getCell(6).getStringCellValue());
				// 错误判断
				if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "书籍名称不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(1) == null || row.getCell(1).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "一级分类不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(2) == null || row.getCell(2).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "二级分类不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(3) == null || row.getCell(3).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "馆藏量不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(4) == null || row.getCell(4).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "书籍编码不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(5) == null || row.getCell(5).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "书籍位置不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(6) == null || row.getCell(6).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "书籍简介不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}else if(row.getCell(6).getStringCellValue().length() > 200) {
					errRowData.put("errMsg", "书籍简介字数超过200");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// 未发现错误且错误数为0
				if (res.getErrorNum() == 0) {
					String fc = row.getCell(1).getStringCellValue().trim();
					int fcid = Integer.parseInt(fc.substring(1, fc.indexOf("_")));
					String sc = row.getCell(2).getStringCellValue().trim();
					int scid = Integer.parseInt(sc.substring(1, fc.indexOf("_")));
					int stock = Integer.parseInt(row.getCell(3).getStringCellValue().trim());
					
					listBook.add(new Book(0, (String)errRowData.get("bookName"), "", fcid, scid, stock, stock, (String)errRowData.get("code"), 2,
							(String)errRowData.get("place"), (String)errRowData.get("introduction"), "", time));
				}
			}
			workbook.close();
			if (res.getErrorNum() > 0) {
				res.setMessage("表格出错");
				return res;
			}
			
			// 数据入库
			if (listBook.size() > 0) {
				for (Book book : listBook) {
					bookservice.insertBook(book);
					res.setSuccessNum(res.getSuccessNum()+1);
				}
				
				res.setStateCode(200);
				res.setMessage("导入成功");
				return res;
			}
		}
		
		res.setMessage("上传文件后缀名不是xls");
        return res;
	}
}
