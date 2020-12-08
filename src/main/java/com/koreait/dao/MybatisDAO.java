package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.koreait.vo.BoardVO;
import com.koreait.vo.InterestVO;
import com.koreait.vo.MemberVO;

public interface MybatisDAO {

	void insert(MemberVO memberVO);				// 회원가입 

	void insertlist(InterestVO interestVO);		// 회원가입시 관심분야 

	int idchk(String id);						// 로그인 ID 존재 유무

	void write(BoardVO boardVO);				// 글 쓰기

	int newestCount();							// 사회게시판 글 개수 구하기

	ArrayList<BoardVO> newestList(HashMap<String, Integer> hmap);


}
