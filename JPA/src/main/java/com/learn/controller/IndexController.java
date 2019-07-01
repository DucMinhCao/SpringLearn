package com.learn.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController implements ErrorController{

	private static final String PATH="/erro";
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(PATH)
	public String erro() {
		return "No mapping available";
	}
}
