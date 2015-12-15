package com.hnb.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.MemberMapper;
import com.hnb.mapper.MovieMapper;
import com.hnb.movie.MovieController;

@Service
public class MemberServiceImpl  implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private SqlSession sqlSession;

	
	// 회원가입
	@Override
	public int join(MemberVO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.insert(member);
	}
	
	// 전체 회원목록 조회
	@Override
	public List<MemberVO> getList(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.selectAll(command);
	}
	
	// 임의의 검색어로 조회
	@Override
	public List<MemberVO> searchByKeyword(String column, String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.selectSomeBy(column, keyword);
	}
	
	// ID로 회원검색
	@Override
	public MemberVO selectById(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.selectOneBy(id);
	}
	
	// 총 회원 수 검색
	@Override
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.count();
	}
	
	// 로그인 
	   @Override
	   public MemberVO login(String id, String pass) {
	      logger.info("MemberServiceImpl : login");
	      MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	         MemberVO loginMember = null;
	         loginMember = mapper.selectOneBy(id);
	         if (loginMember.getId() == null) {
	            return null;
	         } 
	         if (loginMember.getPassword().equals(pass)) {
	            return loginMember;
	         }else{
	            return null;
	         }
	      
	   }
	
	// 회원정보 변경
	@Override
	public int change(MemberVO member) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.update(member);
	}
	
	// 회원탈퇴
	@Override
	public int remove(String id) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); 
		return mapper.delete(id);
	}
}
