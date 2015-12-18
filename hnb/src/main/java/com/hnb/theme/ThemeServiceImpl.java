package com.hnb.theme;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ThemeMapper;

@Service
public class ThemeServiceImpl implements ThemeService{
	private static final Logger logger = LoggerFactory.getLogger(ThemeServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public int insert(ThemeVO theme) {
		logger.info("ThemeServiceImpl : insert() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.insert(theme);
	}

	@Override
	public List<ThemeVO> getList(Command command) {
		logger.info("ThemeServiceImpl : getList() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.getList(command);
	}

	@Override
	public List<ThemeVO> searchByKeyword(Command command) {
		logger.info("ThemeServiceImpl : searchByKeyword() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.searchByKeyword(command);
	}

	@Override
	public ThemeVO selectById(int rcdNo) {
		logger.info("ThemeServiceImpl : selectById() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.selectById(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ThemeServiceImpl : count() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ThemeServiceImpl : countByKeyword() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int change(ThemeVO theme) {
		logger.info("ThemeServiceImpl : change() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.change(theme);
	}

	@Override
	public int remove(int rcdNo) {
		logger.info("ThemeServiceImpl : remove() 진입");
		ThemeMapper mapper = sqlSession.getMapper(ThemeMapper.class);
		return mapper.remove(rcdNo);
	}

}
