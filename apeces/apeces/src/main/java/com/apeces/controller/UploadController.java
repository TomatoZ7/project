package com.apeces.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/upload")
@RestController
public class UploadController {
	
	/**
	 * 
	 * @param file
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		String save_path = "";
		String filename = "";
		String url = "";
		
		if (null!=file && file.getOriginalFilename().length() > 0) {
			save_path = "/upload/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
			
			// ��ȡ�ϴ��ļ���ԭʼ����
			String originalFilename = file.getOriginalFilename();
			
			//��ȡ��Ŀ����Ŀ¼�� 
			File rootPath = new File("D:/eclipse-workspace/apeces_file");
			File uploadFile = new File(rootPath.getPath() + save_path);
			
			// ��������ļ��ĵ�ַ�����ڣ����ȴ���Ŀ¼
			if (!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			
			filename = UUID.randomUUID() + "_" + originalFilename;
			url = rootPath.getPath() + save_path + filename;
			
			try {
				// ʹ��MultipartFile�ӿڵķ�������ļ��ϴ���ָ��λ��
				file.transferTo(new File(url));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		HashMap<String,String> res = new HashMap<>();
		res.put("data", save_path + filename);
		res.put("code", "200");
		return res;
	}
}
