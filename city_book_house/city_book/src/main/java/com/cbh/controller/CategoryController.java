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
		
		// 一级分类处理
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
		
		// 二级分类处理
		if (second_cate != null) {
			Category secondCate = new Category();
			secondCate.setCategory_name(second_cate);
			secondCate.setPid(pid);
			secondCate.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			result = categoryService.insertCategory(secondCate);
		}
		
		if (result == 0) {
        	return new Result(403, "失败。");
        }

        return new Result(200, "成功。");
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public Result updateCategory(@PathVariable int id, @RequestBody Map<String, String> params) {
		String first_cate = params.get("first_cate");
		String second_cate = params.get("second_cate");
		
		// 二级分类
		Category secondCate = categoryService.getCategoryByid(id);
		// 一级分类
		Category firstCate = secondCate.getFirstCate();
		
		if (firstCate.getCategory_name() != first_cate) {
			// 一级分类 修改
			firstCate.setCategory_name(first_cate);
			categoryService.updateCategory(firstCate);
		}

		secondCate.setCategory_name(second_cate);
		int result = categoryService.updateCategory(secondCate);
		
        if (result == 0) {
        	return new Result(403, "更新失败。");
        }

        return new Result(200, "更新成功。");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delCategoryById(@PathVariable int id) {
        int res = categoryService.delCategoryById(id);
        if (res == 0) {
        	return new Result(403, "删除失败");
        }

        return new Result(200, "删除成功");
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
	 * 模板导出
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/template")
	public void excel(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		//创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("分类模板");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("一级分类");
        titleRow.createCell(1).setCellValue("二级分类");
        
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("分类模板".getBytes(),"iso-8859-1") + ".xls");
        
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
        wb.close();
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
	public ImportResult importCate(@RequestBody MultipartFile file) throws IOException, ParseException {
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
		
		List<firstCategory> listCate = new ArrayList<>();
		
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
				// 每一行错误信息收集
				Map<String, Object> errRowData = new HashMap<String, Object>();
				errRowData.put("firstCate", row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue());
				errRowData.put("SecondCate", row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue());
				// 一级分类错误
				if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "一级分类不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// 二级分类错误
				if (row.getCell(1) == null || row.getCell(1).getStringCellValue().trim().isEmpty()) {
					errRowData.put("errMsg", "二级分类不能为空");
					errData.add(errRowData);
					res.setErrorNum(res.getErrorNum()+1);
					continue;
				}
				// 未发现错误且错误数为0
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
				res.setMessage("表格出错");
				return res;
			}
			
			// 数据入库
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
				res.setMessage("导入成功");
				return res;
			}
		}
		
		res.setMessage("上传文件后缀名不是xls");
        return res;
	}
}
