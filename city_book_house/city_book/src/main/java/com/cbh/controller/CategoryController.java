package com.cbh.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cbh.domain.Category;
import com.cbh.pojo.firstCategory;
import com.cbh.service.CategoryService;
import com.cbh.utils.ImportResult;
import com.cbh.utils.Result;

@RequestMapping(value = "/category")
@RestController
public class CategoryController {
	@Autowired
    CategoryService categoryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public HashMap<?,?> index(
			@RequestParam Integer offset,
			@RequestParam Integer limit,
			Integer first_category_id,
			Integer second_category_id) {
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		param.put("first_category_id", first_category_id);
		param.put("second_category_id", second_category_id);
		
		List<List<?>> list = categoryService.getCategoryList(param);
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("data", list.get(0));
		res.put("total", list.get(1).get(0));
		return res;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getCategoryByid(@PathVariable int id) {
		Category category = categoryService.getCategoryByid(id);
        if (category == null) {
        	return new Category();
        }
        return category;
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result insertCategory(@RequestBody Map<String, String> params) {
		int result = 1;
		String first_cate = params.get("first_cate");
		String second_cate = params.get("second_cate");
		
		// һ�����ദ��
		Category firstCate = categoryService.getCategoryByName(first_cate);
		System.out.println(firstCate);
		int pid;

		if (firstCate == null) {
			Category newFirstCate = new Category();
			newFirstCate.setCategory_name(first_cate);
			newFirstCate.setPid(0);
			newFirstCate.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			categoryService.insertCategory(newFirstCate);
			
			pid = newFirstCate.getId();
		}else {
			pid = firstCate.getId();
		}
		
		// �������ദ��
		if (second_cate != null) {
			Category secondCate = new Category();
			secondCate.setCategory_name(second_cate);
			secondCate.setPid(pid);
			secondCate.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			result = categoryService.insertCategory(secondCate);
		}
		
		if (result == 0) {
        	return new Result(403, "ʧ�ܡ�");
        }

        return new Result(200, "�ɹ���");
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public Result updateCategory(@PathVariable int id, @RequestBody Map<String, String> params) {
		String first_cate = params.get("first_cate");
		String second_cate = params.get("second_cate");
		
		// ��������
		Category secondCate = categoryService.getCategoryByid(id);
		// һ������
		Category firstCate = secondCate.getFirstCate();
		
		if (firstCate.getCategory_name() != first_cate) {
			// һ������ �޸�
			firstCate.setCategory_name(first_cate);
			categoryService.updateCategory(firstCate);
		}

		secondCate.setCategory_name(second_cate);
		int result = categoryService.updateCategory(secondCate);
		
        if (result == 0) {
        	return new Result(403, "����ʧ�ܡ�");
        }

        return new Result(200, "���³ɹ���");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delCategoryById(@PathVariable int id) {
        int res = categoryService.delCategoryById(id);
        if (res == 0) {
        	return new Result(403, "ɾ��ʧ��");
        }

        return new Result(200, "ɾ���ɹ�");
    }
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HashMap<?,?> all() {
		List<List<?>> list = categoryService.getCategoryWithLevel();
		
		HashMap<String,Object> res = new HashMap<>();
		res.put("first", list.get(0));
		res.put("second", list.get(1));
		return res;
	}
	
	/**
	 * ģ�嵼��
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/template")
	public void excel(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		//����excel�ļ�
        HSSFWorkbook wb = new HSSFWorkbook();
        //����sheetҳ
        HSSFSheet sheet = wb.createSheet("����ģ��");
        //����������
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("һ������");
        titleRow.createCell(1).setCellValue("��������");
        
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("����ģ��".getBytes(),"iso-8859-1") + ".xls");
        
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        wb.close();
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
	public ImportResult importCate(@RequestBody MultipartFile file) throws IOException, ParseException {
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
		
		List<firstCategory> listCate = new ArrayList<>();
		
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
				// ÿһ�д�����Ϣ�ռ�
				Map<String, Object> errRowData = new HashMap<String, Object>();
				errRowData.put("firstCate", row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue());
				errRowData.put("SecondCate", row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue());
				// һ���������
				if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "һ�����಻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// �����������
				if (row.getCell(1) == null || row.getCell(1).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "�������಻��Ϊ��");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// δ���ִ����Ҵ�����Ϊ0
				if (res.getErrorNum() == 0) {
					Category secondCate = new Category(0, row.getCell(1).getStringCellValue().trim(), -1, time);
					for (firstCategory firstCate : listCate) {
						if (firstCate.getCategory_name() == row.getCell(0).getStringCellValue().trim()) {
							firstCate.getSecond_cate().add(secondCate);
							continue a;
						}
					}
					
					firstCategory nfirstCate = new firstCategory(0, row.getCell(0).getStringCellValue().trim(), 0, time, new ArrayList<Category>());
					nfirstCate.getSecond_cate().add(secondCate);
					listCate.add(nfirstCate);
				}
			}
			workbook.close();
			if (res.getErrorNum() > 0) {
				res.setMessage("������");
				return res;
			}
			
			// �������
			if (listCate.size() > 0) {
				for (firstCategory row : listCate) {
					categoryService.insertExcCate(row);
					int pid = row.getId();
					res.setSuccessNum(res.getSuccessNum()+1);
					if (row.getSecond_cate().size() > 0) {
						for (Category child : row.getSecond_cate()) {
							child.setPid(pid);
							categoryService.insertCategory(child);
							res.setSuccessNum(res.getSuccessNum()+1);
						}
					}
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
