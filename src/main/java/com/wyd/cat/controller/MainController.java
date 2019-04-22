package com.wyd.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cat")
public class MainController extends BaseController{
	
	/**首页*/
	@RequestMapping("/index")
	public String index() {
		return "/common/index";
	}
	
	/**记录生活*/
	@RequestMapping("/life")
	public String gallery() {
		return "/common/life";
	}
	/**记录生活*/
	@RequestMapping("/contact")
	public String contact() {
		return "/common/contact";
	}
	/**生活详情*/
	@RequestMapping("/single")
	public String single() {
		return "/common/single";
	}
}
