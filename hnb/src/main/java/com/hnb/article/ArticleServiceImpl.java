package com.hnb.article;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ArticleMapper;
import com.hnb.member.MemberServiceImpl;

@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private SqlSession sqlSession;
	
	@Override
	public int write(ArticleVO article) {
		logger.info("ArticleServiceImpl : write() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.write(article);
	}

	@Override
	public List<ArticleVO> getList(Command command) {
		logger.info("ArticleServiceImpl : write() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.getList(command);
	}

	@Override
	public List<ArticleVO> searchByKeyword(Command command) {
		logger.info("ArticleServiceImpl : searchByKeyword() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.searchByKeyword(command);
	}

	@Override
	public ArticleVO selectById(int rcdNo) {
		logger.info("ArticleServiceImpl : selectById() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.selectById(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ArticleServiceImpl : count() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ArticleServiceImpl : countByKeyword() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int change(ArticleVO article) {
		logger.info("ArticleServiceImpl : change() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.write(article);
	}

	@Override
	public int remove(int rcdNo) {
		logger.info("ArticleServiceImpl : remove() 진입");
		ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
		return mapper.remove(rcdNo);
	}

}
