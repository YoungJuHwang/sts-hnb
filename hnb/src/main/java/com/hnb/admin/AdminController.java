package com.hnb.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberServiceImpl memberService;
	@Autowired MemberVO member;
	@Autowired MovieVO movie;
	
	@RequestMapping("/main") // admin/admin으로 보내기 위해 home으로 임의로 약속.
	public String home(){ // admin의 default로 가는 메소드 약속해놈. 완벽한 모델의 분리.
		logger.info("어드민컨트롤러-Home() 진입");
		return "admin/admin/main.tiles";
	}
	@RequestMapping("/movie_list")
	public String movieList(){
		
		logger.info("어드민컨트롤러-movieList() 진입");
		
		return "admin/movie_list";
	}
	@RequestMapping("/member_list/{pageNo}")
	public @ResponseBody Map<String, Object> memberList(
			@PathVariable("pageNo")String pageNo, //default값을 jsp에서 지정함.
			Model model){
		logger.info("어드민컨트롤러 - memberList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		Command command = CommandFactory.list(pageNo);
		int pageSize = 5;
		int groupSize = 3;
		int count = memberService.count();
		int totPage = 0;
		
		totPage = (count % pageSize) == 0 ? count / pageSize : count / pageSize + 1;
		
		int pageNum = Integer.parseInt(pageNo);
		int startPage = pageNum - ((pageNum - 1) & groupSize);
		
		int lastPage = 0;
		lastPage = (startPage + pageSize - 1) <= totPage ? startPage + groupSize - 1 : totPage;
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", memberService.getList(CommandFactory.list(pageNo)));
		map.put("count", memberService.count());
		map.put("pageNo", pageNo);
		map.put("startPage", startPage);
		map.put("groupSize", groupSize);
		map.put("lastPage", lastPage);
		map.put("totPage", totPage);
		
		return map;
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
