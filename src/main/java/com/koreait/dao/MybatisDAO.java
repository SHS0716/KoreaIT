package com.koreait.dao;

import com.koreait.vo.InterestVO;
import com.koreait.vo.MemberVO;

public interface MybatisDAO {

	void insert(MemberVO memberVO);

	void insertlist(InterestVO interestVO);

	int idchk(String id);


}
