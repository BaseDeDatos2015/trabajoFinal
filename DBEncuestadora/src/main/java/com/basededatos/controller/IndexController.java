package com.basededatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public IndexController() {
		super();
	}

	@RequestMapping(value = "/")
	public String index() {
		return "home";
	}

}
