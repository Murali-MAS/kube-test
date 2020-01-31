package com.demo.app.searchservices.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/search")
public class SearchEnvironmentController {

	@RequestMapping(path = "/env")
	@ResponseBody
	public Map<String, String> GetEnvironmentVariables() {

		Map<String, String> env = System.getenv();

		return env;
	}
}
