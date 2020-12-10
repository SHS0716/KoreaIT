package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.koreait.vo.BoardVO;
import com.koreait.vo.InterestVO;
import com.koreait.vo.MemberVO;

public interface MybatisDAO {

	void insert(MemberVO memberVO);									// 회원가입 
	void insertlist(InterestVO interestVO);							// 회원가입시 관심분야 
	
	int login_id(String id);
	String login_pw(String id);
	
	void write(BoardVO boardVO);									// 글 쓰기

	int socailCount();												// 사회 게시판 글 개수 구하기
	ArrayList<BoardVO> socailList(HashMap<String, Integer> hmap);	// 사회게시판 글 나열

	int enterCount();												// 연예 게시판
	ArrayList<BoardVO> enterList(HashMap<String, Integer> hmap);	

	int sportsCount();												// 스포츠 게시판								
	ArrayList<BoardVO> sportsList(HashMap<String, Integer> hmap);	

	int ITCount();													// IT 게시판
	ArrayList<BoardVO> ITList(HashMap<String, Integer> hmap);		
	
	int gameCount();												// 게임 게시판
	ArrayList<BoardVO> gameList(HashMap<String, Integer> hmap);		
	
	int shoppingCount();											// 쇼핑 게시판
	ArrayList<BoardVO> shoppingList(HashMap<String, Integer> hmap);	
	
	int freeCount();												// 자유 게시판
	ArrayList<BoardVO> freeList(HashMap<String, Integer> hmap);
	
	void increment(int bidx);										// 조회수 증가		
	
	BoardVO selectBybidx(int bidx);									// 글 출력
	
	

}
