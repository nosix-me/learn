package com.hyx.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hyx.springmvc.bean.City;
import com.hyx.springmvc.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Resource
	private CityService cityService;
	
	@RequestMapping("/name")
	public String cityName(HttpServletRequest request, Model model) {
		Long id = Long.parseLong(request.getParameter("id")); 
		City city = cityService.getCityById(id);
		model.addAttribute("city", city);
		return "showCity";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public String cityInfo(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id")); 
		City city = cityService.getCityById(id);
		Gson gson = new Gson();
		return gson.toJson(city);
	}
}
