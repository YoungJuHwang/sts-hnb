package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.movie.MovieController;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/join")
	public String joinMember(
			/*@ModelAttribute("member")MemberVO member => 여기서 @ModelAttribute("member")가 생략가능*/ 
			MemberVO member
			){
		return "member/join_member";
	}
	
	
	
	
}
