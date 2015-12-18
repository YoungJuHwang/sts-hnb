package com.hnb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnb.global.Command;
import com.hnb.theme.ThemeVO;

@Repository
public interface ThemeMapper {

	int insert(ThemeVO theme);
	int change(ThemeVO theme);
	int countByKeyword(Command command);
	int count();
	ThemeVO selectById(int rcdNo);
	List<ThemeVO> searchByKeyword(Command command);
	List<ThemeVO> getList(Command command);
	int remove(int rcdNo);
}
