package com.hnb.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@RequestMapping("/article")
	public String article(){
		logger.info("EventController - article() 진입");
		
		return "event/article.tiles";
	}
}
