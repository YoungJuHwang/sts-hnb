package com.hnb.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping("/home")
	public String Movie(){
		logger.info("무비컨트롤러-Movie() 진입");
		return "movie/Movie";
	}
	@RequestMapping("/infomation")
	public String movieInfo(){
		logger.info("무비컨트롤러-movieInfo() 진입");
		return "movie/movie_infe";
	}
	@RequestMapping("/name")
	public String movieName(){
		logger.info("무비컨트롤러-movieName() 진입");
		return "movie/movie_name";
	}
	@RequestMapping("/cut")
	public String movieCut(){
		logger.info("무비컨트롤러-movieCut() 진입");
		return "movie/movie_Cut";
	}
	@RequestMapping("/trailer")
	public String movieTra(){
		logger.info("무비컨트롤러-movieTra() 진입");
		return "movie/movie_Tra";
	}
	@RequestMapping("/basic")
	public String movieBasic(){
		logger.info("무비컨트롤러-movieBasic() 진입");
		return "movie/movie_Basic";
	}
	@RequestMapping("/chart")
	public String movieChart(){
		logger.info("무비컨트롤러-movieChart() 진입");
		return "movie/movie_Chart";
	}
	
	
	
	
	
	
	
	
	
}
