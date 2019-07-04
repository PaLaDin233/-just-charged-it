package xyz.zhhg.jci.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@RequestMapping(value="/hello",produces="application/json;charset=UTF-8")
	public @ResponseBody String hello() {
		//System.out.println("hello!");
		return "{data:'你好！世界'}";
	}
	
	
}
