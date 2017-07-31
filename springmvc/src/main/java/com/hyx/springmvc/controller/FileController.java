package com.hyx.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("file")
public class FileController {

	@RequestMapping("/upload1")
	public String fileUpload1(@RequestParam("file") CommonsMultipartFile file, Model model) throws IllegalStateException, IOException {
		long stime = System.currentTimeMillis();
		String path = "/Users/nosix/Downloads/tmp/"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
		File newFile = new File(path);
		file.transferTo(newFile);
		model.addAttribute("file_name", newFile.getName());
		model.addAttribute("size", newFile.getTotalSpace());
		System.out.println("耗时:"+(System.currentTimeMillis() - stime));
		return "/success";
	}
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, Model model) {
		return "upload";
	}
}
