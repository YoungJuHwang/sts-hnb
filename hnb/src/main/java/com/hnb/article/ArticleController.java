package com.hnb.article;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.event.EventController;
import com.hnb.global.Command;
import com.hnb.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleservice;
	
	// Restful 방식(url에 {}가 있어 @PathVariable을 사용)
	@RequestMapping("/list/{themeNo}/{pageNo}")
	public @ResponseBody List<ArticleVO> getList(
			@PathVariable("themeNo")String themeNo,
			@PathVariable("pageNo")String pageNo,
			//@PathVariable("pageNo")String pageNo, //default값을 jsp에서 지정함.
			Model model){
		logger.info("ArticleController - articleList() 진입");
		logger.info("넘어온 페이지 번호 : {}",themeNo);
		logger.info("넘어온 게시판 테마번호 : {}",pageNo);
		List<ArticleVO> list = articleservice.getList(CommandFactory.boardList(pageNo, themeNo));
		/*int count = service.count();
		model.addAttribute("memberList",list);
		model.addAttribute("count",service.count());
		model.addAttribute("pageNo",pageNo);*/
		logger.info("검색한 게시판 글 수 : {}",list.size());
		return list;
	}
	@RequestMapping("/list")
	public String goList(){
		logger.info("ArticleController - goList() 진입");
		return "article/list.tiles";
	}
	@RequestMapping("/write")
	public String write(){
		logger.info("ArticleController - write() 진입");
		return "article/write.jsp";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody ArticleVO article){
		logger.info("ArticleController - save() 진입");
		return "article/write.jsp";
	}
	
}
