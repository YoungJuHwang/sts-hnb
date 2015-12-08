package com.hnb.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.main.MainController;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	MemberServiceImpl service; // 17,18번째줄 : service를 쓰기 위한 것. 콩책128
	@Autowired
	MemberVO member; // MemberVO 부분은 빈객체를 불러옴.위에도 마찬가지.
	@Autowired
	MovieVO movie;
	
	@RequestMapping("/home") // admin/admin으로 보내기 위해 home으로 임의로 약속.
	public String home(){ // admin의 default로 가는 메소드 약속해놈. 완벽한 모델의 분리.
		logger.info("어드민컨트롤러-Home() 진입");
		return "admin/Admin";
	}
	@RequestMapping("/movie_list")
	public String movieList(){
		
		logger.info("어드민컨트롤러-movieList() 진입");
		
		return "admin/movie_list";
	}
	@RequestMapping("/member_list")
	public String memberList(){
		logger.info("어드민컨트롤러-memberList() 진입");
		return "admin/member_list";
	}
	@RequestMapping("/member_profile")
	public String memberProfile(){
		logger.info("어드민컨트롤러-memberProfile() 진입");
		return "admin/member_profile";
	}
	@RequestMapping("/movie_profile")
	public String movieProfile(){
		logger.info("어드민컨트롤러-movieProfile() 진입");
		return "admin/movie_profile";
	}
	@RequestMapping("/insert")
	public String insert(){
		logger.info("어드민컨트롤러-insert() 진입");
		return "admin/insert";
	}
	@RequestMapping("/insert2")
	public String insert2(){
		logger.info("어드민컨트롤러-insert2() 진입");
		return "admin/insert2";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("어드민컨트롤러-delete() 진입");
		return "admin/delete";
	}
	
	
	
	
	
	
	
}
