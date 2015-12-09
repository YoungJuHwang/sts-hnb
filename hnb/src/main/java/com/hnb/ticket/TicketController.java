package com.hnb.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	@Autowired
	TicketServiceImpl service;
	@Autowired
	TicketVO ticket;
	
	@RequestMapping("/Ticket")
	public String ticket(){
		
		return "ticket/Ticket";
	}
	
	
	
	
	
	
	
	
}
