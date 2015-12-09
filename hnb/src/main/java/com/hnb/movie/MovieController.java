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
import org.springframework.web.bind.annotation.ResponseBody;


@Controller //context가 함
@RequestMapping("/movie") //mvc ns가 함.
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;  //얘는 root-context.xml안에 존재함. 여기 필드에 있는것처럼 보이는 것.
	
	@RequestMapping("/home")
	public String movie(){
		logger.info("무비컨트롤러-Movie() 진입");
		return "movie/Movie"; //여기에서 return은 페이지 이동.
	}
	/*@RequestMapping("/infomation")
	public String movieInfo(Model model){
		logger.info("무비컨트롤러-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList",list);
		logger.info("무비컨트롤러-movieInfo() 완료 : {}",list); //{}는 ? 느낌으로
		return "movie/movie_infe";
	}*/ 
	// 리스트로 던질 때는 model에 담아서 던지는 것이 가장 간단함.
	@RequestMapping("/infomation")
	public Model movieInfo(Model model){
		logger.info("무비컨트롤러-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList",list);
		logger.info("무비컨트롤러-movieInfo() 완료 : {}",list); //{}는 ? 느낌으로
		return model;
	}
/*	@RequestMapping("/movie_name/{movieName}")
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
	}*/
	// movieName을 수정 : 페이지 이동은 스트링, AJAX는 객체를 반환하면 됨.
	// 스트링 하나를 보낼때도 빈 객체로 만들어서 보내는 것을 추천.
	// 객체지향 프로그래밍. 보안에도 스트링을 던지는 것과 객체를 던지는 것이 차이가 있다.
	// 객체 자체를 던지기 때문에 model이 필요가 없다.
	// 리스트를 던지는 경우는 책 267 참고..
	// 나중에 Member와 movie를 합친 슈퍼객체라고 부름..
	@RequestMapping("/movie_name/{movieName}")
	public @ResponseBody MovieVO movieName( //responseBody는 JSON타입.
			@RequestParam("movieName")String filmNumber,
			Model model	
			){
		logger.info("무비컨트롤러-movieName() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화 제목 : {}",movie.getFilmName());
		model.addAttribute("movie",movie);
		return movie;
	}
	@RequestMapping("/cut")
	public Model movieCut(
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
		return model;
	}
	@RequestMapping("/trailer")
	public Model movieTra(
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
		return model;
	}
	@RequestMapping("/basic")
	public @ResponseBody MovieVO movieBasic(
			@RequestParam("filmNumber")String filmNumber,
			Model model
			){
		logger.info("무비컨트롤러-movieBasic() 진입");
		logger.info("영화 아이디 : {}",filmNumber);
		movie = service.searchByName(filmNumber);
		logger.info("영화 제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return movie;
	}
	
	//리스트를 던질때..
	@RequestMapping("/chart")
	public Model movieChart(Model model){
		logger.info("무비컨트롤러-movieChart() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList2", list);
		return model;
	}
	
	
	
	
	
	
	
	
	
}
