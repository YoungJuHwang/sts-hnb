package com.hnb.movie;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;  //얘는 root-context.xml안에 존재함. 여기 필드에 있는것처럼 보이는 것.
	
	@RequestMapping("/home")
	public String Movie(){
		logger.info("무비컨트롤러-Movie() 진입");
		return "movie/Movie";
	}
	@RequestMapping("/infomation")
	public String movieInfo(Model model){
		logger.info("무비컨트롤러-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList",list);
		logger.info("무비컨트롤러-movieInfo() 완료 : {}",list); //{}는 ? 느낌으로
		return "movie/movie_infe";
	}
	@RequestMapping("/movie_name/{movieName}")
	public String movieName(
			@RequestParam("movieName")String filmNumber, //요게 filmNumber = request.getParameter("filmNumber"); "" 안의 값이 나중에 ajax에서 보내는 놈이랑 같아야 한다.
			Model model	
			){
		logger.info("무비컨트롤러-movieName() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화 제목 : {}",movie.getFilmName());
		model.addAttribute("movie",movie); // 이렇게하면 무비 객체를 담은거.
		return "movie/movie_name";
	}
	@RequestMapping("/cut")
	public String movieCut(
			/*@RequestParam("filmNumber")String filmNumber => @RequestParam("filmNumber")생략가능*/
			String filmNumber,
			Model model
			){
		logger.info("무비컨트롤러-movieCut() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String cut = movie.getCut();
		String[] arr = cut.split("/");
		logger.info("영화 컷 : {}",arr);
		model.addAttribute("arr",arr);
		return "movie/movie_Cut";
	}
	@RequestMapping("/trailer")
	public String movieTra(
			@RequestParam("filmNumber")String filmNumber,
			Model model
			){
		logger.info("무비컨트롤러-movieTra() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		String tra = movie.getTrailer();
		String[]arrt = tra.split("/");
		logger.info("영화 트레일러 : {}",arrt);
		model.addAttribute("arrt",arrt);		
		return "movie/movie_Tra";
	}
	@RequestMapping("/basic")
	public String movieBasic(
			@RequestParam("filmNumber")String filmNumber,
			Model model
			){
		logger.info("무비컨트롤러-movieBasic() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화 제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return "movie/movie_Basic";
	}
	@RequestMapping("/chart")
	public String movieChart(Model model){
		logger.info("무비컨트롤러-movieChart() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList2", list);
		return "movie/movie_Chart";
	}
	
	
	
	
	
	
	
	
	
}
