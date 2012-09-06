package com.methodinvoke.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Index controller.
 * Just for fun :)
 * @Author Prakash Sapkota
 */
@Controller
public class HomeController {
	@RequestMapping("/")
	String doGetIndex(){
		return "home";
	}
}
