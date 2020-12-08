package com.koreait.springMybatisSetting;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.dao.MybatisDAO;
import com.koreait.vo.BoardList;
import com.koreait.vo.BoardVO;
import com.koreait.vo.InterestVO;
import com.koreait.vo.MemberVO;

// 커밋 테스트123123456456zzzz
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		System.out.println("컨트롤러의 login() 메소드 실행");
		return "home";
	}
	
//	로그인
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 login() 메소드 실행");
		return "loginOK";
	}
	
//	사용자 ID, PW 확인
	@RequestMapping("/loginOK")
	public String loginOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 loginOK() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		int result = mapper.idchk(id);
		System.out.println(result);
		if(result == 0) {
			
			return "loginfail";
		} else {
			return "main";
		}
		
		
	}
	
//	회원가입 홈페이지 이동
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 join() 메소드 실행");
		return "join";
	}
	
//	회원가입
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insert() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MemberVO memberVO = ctx.getBean("memberVO", MemberVO.class);
		InterestVO interestVO = ctx.getBean("interestVO", InterestVO.class);
		String id = request.getParameter("id");
		memberVO.setId(id);
		memberVO.setPassword(request.getParameter("password"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setGender(request.getParameter("gender"));
		memberVO.setDateofbirthday(request.getParameter("dateofbirthday"));
		memberVO.setEmail(request.getParameter("email"));
		memberVO.setPhone(request.getParameter("phone"));
		mapper.insert(memberVO);
		System.out.println(memberVO);
		
		interestVO.setInterests_list(request.getParameterValues("interests_list"));
		for (int i = 0; i < interestVO.getInterests_list().length; i++) {
			interestVO.setId(id);
			interestVO.setInterests(interestVO.getInterests_list()[i]);
			System.out.println(interestVO.getInterests());
			mapper.insertlist(interestVO);
		}
		return "insert";
	}
	
//	메인 페이지
	@RequestMapping("/main")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 list() 메소드 실행");
		
		return "main";
	}
	
//	게시판 글쓰기
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 write() 메소드 실행");
		return "write";
	}
	
	@RequestMapping("/writeOK")
	public String writeOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 writeOK() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardVO boardVO = ctx.getBean("boardVO", BoardVO.class);
		
		boardVO.setCategory(request.getParameter("category"));
		boardVO.setRef(Integer.parseInt(request.getParameter("ref")));
		boardVO.setName(request.getParameter("name"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContent(request.getParameter("content"));
		System.out.println(boardVO);
		
		mapper.write(boardVO);
		return "main";
	}
	
	
//	게시판 이동
	@RequestMapping("/newestBoard")
	public String newestBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 newestBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.newestCount();		// 사회 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.newestList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "newestBoard";
	}
	
}
