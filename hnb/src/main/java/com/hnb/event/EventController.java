package com.hnb.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.admin.AdminServiceImpl;
import com.hnb.article.ArticleServiceImpl;
import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired MemberServiceImpl memberService;
	@Autowired MemberVO memberVO;
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleservice;
	
	// Restful 방식(url에 {}가 있어 @PathVariable을 사용)
	@RequestMapping("/boardList/{pageNo}")
	public @ResponseBody List<ArticleVO> boardList(
			@PathVariable("pageNo")String pageNo, //default값을 jsp에서 지정함.
			Model model){
		logger.info("EventController - boardList() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		Command command = CommandFactory.list(pageNo);
		List<ArticleVO> list = articleservice.getList(command);
		/*int count = service.count();
		model.addAttribute("memberList",list);
		model.addAttribute("count",service.count());
		model.addAttribute("pageNo",pageNo);*/
		return list;
	}
	
	@RequestMapping("/memberSearch/{pageNo}")
	public String memberSearch(
			
			@PathVariable("pageNo")String pageNo,
			@RequestParam("keyword")String keyword, //"keyword"는 jsp파일의 네임값.
			@RequestParam("column")String column,
			Model model
			){
		logger.info("EventController - memberSearch() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		logger.info("넘어온 컬럼 : {}",column);
		logger.info("넘어온 검색어 : {}",keyword);
		Command command = CommandFactory.search(column, keyword, pageNo);
		List<MemberVO> list = memberService.searchByKeyword(command);
		int count = memberService.countByKeyword(command);
		logger.info("리스트 결과: {}",list.size());
		model.addAttribute("memberList",list);
		model.addAttribute("pageNo",pageNo);
		model.addAttribute("count",count); // 여기서 count는 전체회원이 아닌 검색된 회원수
		
		return "event/boardSearch.tiles";
	}
	
	@RequestMapping("/boardList")
	public String goList(){
		logger.info("EventController - goList() 진입");
		return "event/boardList.tiles";
	}
	
	// SOAP 방식 처리(url에 ? 있는 경우, @RequestParam 사용 즉 쿼리스트링(? 뒤에거)을 사용)
	/*@RequestMapping("/boardList")
	public String boardList2(
			@RequestParam(value="pageNum", defaultValue="1")String pageNo,
			@RequestParam(value="column", required=false)String column,
			@RequestParam(value="searchKey", required=false)String searchKey,
			Model model){
		logger.info("EventController - boardList2() 진입");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		logger.info("넘어온 컬럼 : {}",column);
		logger.info("넘어온 검색어 : {}",searchKey);
		Command command = CommandFactory.list(pageNo);
		List<MemberVO> list = service.getList(command);
		int count = service.count();
		model.addAttribute("memberList",list);
		model.addAttribute("count",count);
		model.addAttribute("pageNo",pageNo);
		return "event/boardList.tiles";
	}*/
}
