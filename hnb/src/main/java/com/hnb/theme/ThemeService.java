package com.hnb.theme;

import java.util.List;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;

public interface ThemeService {
	// C : 추가
	public int insert(ThemeVO theme);
	
	// R : 조회
	public List<ThemeVO> getList(Command command);
	public List<ThemeVO> searchByKeyword(Command command); 
	public ThemeVO selectById(int rcdNo); 
	public int count(); 
	public int countByKeyword(Command command); 
	
	// U : 개인정보 변경
	public int change(ThemeVO theme);
	
	// D : 삭제
	public int remove(int rcdNo);
}
