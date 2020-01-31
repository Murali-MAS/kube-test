package com.demo.app.licensingservices.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/license")
public class EnvironmentController {

	@RequestMapping(path = "/env")
	@ResponseBody
	public Map<String, String> GetEnvironmentVariables() {

		Map<String, String> env = System.getenv();

		return env;
	}
	@RequestMapping(path = "/ping")
	@ResponseBody
	public String ping() {

		return "license App Services is working::"+System.currentTimeMillis();
	}
}
