package com.hnb.global;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnb.main.MainController;
@Controller
@RequestMapping("/global")
public class GlobalController {
private static final Logger logger = LoggerFactory.getLogger(GlobalController.class);
	
	
	@RequestMapping("/main") //get방식
	public String main(){
		
		return "global/main";
	}
	@RequestMapping(value = "/header") //get방식
	public String header(){
		
		return "global/header";
	}
	@RequestMapping(value = "/jumbotron") //get방식
	public String jumbotron(){
		
		return "global/jumbotron";
	}
	@RequestMapping(value = "/footer") //get방식
	public String footer(){
		
		return "global/footer";
	}
	
	// @RequestMapping("/global/")이 부분이 중복된것 => switch 로 빼낸다..?
}
