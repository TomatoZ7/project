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
		// ���ô���ʱ��
    	book.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
    	int result = bookservice.insertBook(book);
        if (result == 0) {
        	return new Result(403, "���ʧ�ܡ�");
        }

        return new Result(200, "��ӳɹ���");
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Result updateBook(@PathVariable int id, @RequestBody Book book){
		book.setId(id);
    	
        int result = bookservice.updateBook(book);
        if (result == 0) {
        	return new Result(403, "����ʧ�ܡ�");
        }

        return new Result(200, "���³ɹ���");
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delBookById(@PathVariable int id) {
        int res = bookservice.delBookById(id);
        if (res == 0) {
        	return new Result(403, "ɾ��ʧ��");
        }

        return new Result(200, "ɾ���ɹ�");
    }
	
	/**
	 * ģ�嵼��
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/template")
	public void excel(HttpServletResponse response) throws IOException {
		// ���ݳ�ʼ��
		List<firstCategory> listCate = categoryService.getCategory();
		List<String> firstCateList = new ArrayList<String>();
		Map<String, List<String>> secondCateMap = new HashMap<String, List<String>>();
		// ��װ����
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
		//����excel�ļ�
        HSSFWorkbook wb = new HSSFWorkbook();
        //����sheetҳ
        HSSFSheet sheet = wb.createSheet("�鼮ģ��");
        //����������
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("�鼮����");
        titleRow.createCell(1).setCellValue("һ������");
        titleRow.createCell(2).setCellValue("��������");
        titleRow.createCell(3).setCellValue("�ݲ���");
        titleRow.createCell(4).setCellValue("�鼮����");
        titleRow.createCell(5).setCellValue("�鼮λ��");
        titleRow.createCell(6).setCellValue("�鼮���");
        // ����sheet���������ط�������
        HSSFSheet cateSheet = wb.createSheet("cateSheet");
        // ����sheet�Ƿ����� true:����/false:��ʾ
        wb.setSheetHidden(wb.getSheetIndex(cateSheet), false);
        // д������
        writeData(wb, cateSheet, firstCateList, secondCateMap);
        // ����������Ч�� 
        setDataValid(wb, sheet, firstCateList, secondCateMap);
        
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("�鼮ģ��".getBytes(),"iso-8859-1") + ".xls");
        
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        wb.close();
	}
	
	public static void writeData(HSSFWorkbook hssfWorkBook, HSSFSheet cateSheet, List<String> firstCateList, Map<String, List<String>> secondCateMap) {
		//ѭ������������д�� cateSheet �ĵ�1����
		int cateRowId = 0;
		HSSFRow firstCateRow = cateSheet.createRow(cateRowId++);
		firstCateRow.createCell(0).setCellValue("�����б�");
		for (int i = 0; i < firstCateList.size(); i++) {
			firstCateRow.createCell(i + 1).setCellValue(firstCateList.get(i));
		}
		// �����������д�뵽ÿһ���У��п�ͷΪ�������򣬺�����������
		Iterator<String> keyIterator = secondCateMap.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			List<String> son = secondCateMap.get(key);
			HSSFRow cateRow = cateSheet.createRow(cateRowId++);
			cateRow.createCell(0).setCellValue(key);
			for (int i = 0; i < son.size(); i++) {
				cateRow.createCell(i + 1).setCellValue(son.get(i));
			}
			
			// ������ƹ�����
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
			if ((colCount - 25) / 26 == 0 || colCount == 51) {// 26-51֮�䣬�����߽磨��������ĸ����㣩
				if ((colCount - 25) % 26 == 0) {// �߽�ֵ
					endSuffix = (char) ('A' + 25);
				} else {
					endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
				}
			} else {// 51����
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
		//����һ����������
		HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper((HSSFSheet) sheet);
		DataValidationConstraint cateConstraint = dvHelper.createExplicitListConstraint(firstCateList.toArray(new String[] {}));
		CellRangeAddressList cateRangeAddressList = new CellRangeAddressList(1, 100, 1, 1);//��˼�Ǵ�B2��B101 Ϊ����
		DataValidation cateDataValidation = dvHelper.createValidation(cateConstraint, cateRangeAddressList);
		cateDataValidation.createErrorBox("error", "��ѡ����ȷ�ķ���");
		cateDataValidation.setShowErrorBox(true);
		sheet.addValidationData(cateDataValidation);
		
		// ���ö�����������
		for (int i = 0; i <= 100; i++) {
			// "B"��ָ һ������ ���ڵ��У�i+1��ʼֵΪ1����ӵ�2�п�ʼ��2Ҫ�롰B����Ӧ��ΪB���кż�1�������һ������Ϊ��C������ô���һ��������2
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
		// ����������Ϣ��ʾ��Ϣ
		data_validation_list.createPromptBox("����ѡ����ʾ", "��ʹ��������ʽѡ����ʵ�ֵ��");
		return data_validation_list;
	}
	
	/**
	 * ��������
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public ImportResult importBook(@RequestBody MultipartFile file) throws IOException, ParseException {
		// ����ɹ���ʶ��
		List<Map<String,Object>> errData = new ArrayList<Map<String,Object>>();
		ImportResult res = new ImportResult(403, "���Ϊ��", 0, 0, errData);
		// �жϱ���ǲ��ǿյ�
		if (file.getSize() == 0) {
			return res;
		}
		//�õ��ļ�������
		String fileName = file.getOriginalFilename();
		//��ȡ�ļ��ĺ�׺
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// ��ʼ��ʱ��
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		List<Book> listBook = new ArrayList<>();
		
		if ( suffix.equals(".xls") ) {
			// ����Excel����
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
			// Ĭ�� ��ȡExcel�е�sheet1
			HSSFSheet sheet = workbook.getSheetAt(0);
			// ��ȡ�е�����
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			if (physicalNumberOfRows <= 1) {
				workbook.close();
				return res;
			}else if ( physicalNumberOfRows > 101 ) {
				workbook.close();
				res.setMessage("����������ô���100��");
				return res;
			}
			// �б������һ�в����м���
			a:for (int j = 1; j < physicalNumberOfRows; j++) {
				// ��ȡ���е�������Ϣ
				HSSFRow row = sheet.getRow(j);
				// ���� cell type
				row.getCell(3).setCellType(CellType.STRING);
				// ÿһ�д�����Ϣ�ռ�
				Map<String, Object> errRowData = new HashMap<String, Object>();
				errRowData.put("bookName", row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue());
				errRowData.put("firstCate", row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue());
				errRowData.put("SecondCate", row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue());
				errRowData.put("stock", row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue());
				errRowData.put("code", row.getCell(4) == null ? "" : row.getCell(4).getStringCellValue());
				errRowData.put("place", row.getCell(5) == null ? "" : row.getCell(5).getStringCellValue());
				errRowData.put("introduction", row.getCell(6) == null ? "" : row.getCell(6).getStringCellValue());
				// �����ж�
				if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�鼮���Ʋ���Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(1) == null || row.getCell(1).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "һ�����಻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(2) == null || row.getCell(2).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�������಻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(3) == null || row.getCell(3).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�ݲ�������Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(4) == null || row.getCell(4).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�鼮���벻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(5) == null || row.getCell(5).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�鼮λ�ò���Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				if (row.getCell(6) == null || row.getCell(6).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�鼮��鲻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}else if(row.getCell(6).getStringCellValue().length() > 200) {
					errRowData.put("errMsg", "�鼮�����������200");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// δ���ִ����Ҵ�����Ϊ0
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
				res.setMessage("������");
				return res;
			}
			
			// �������
			if (listBook.size() > 0) {
				for (Book book : listBook) {
					bookservice.insertBook(book);
					res.setSuccessNum(res.getSuccessNum()+1);
				}
				
				res.setStateCode(200);
				res.setMessage("����ɹ�");
				return res;
			}
		}
		
		res.setMessage("�ϴ��ļ���׺������xls");
        return res;
	}
}
