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


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		System.out.println("컨트롤러의 home() 메소드 실행");
		return "home";
	}
	
//	사용자 ID, PW 확인
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 loginCheck() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		String id = request.getParameter("id");
		String password = request.getParameter("password");		// login 페이지에서 넘겨받은 id, password
		System.out.println("입력받은 password :" + password);
		int resultId = mapper.login_id(id);						// 
		System.out.println(resultId);
		if (resultId == 1) {									// 입력한 id가 db에 존재함
			String resultPw = mapper.login_pw(id);
			System.out.println("DB에 저장된 password : " + resultPw);
			if (password.equals(resultPw)) {					// 입력한 pw가 DB에 저장된 id에 맞는 pw인지
				System.out.println("ID, PW 일치");
				return "redirect:loginOK";
			} else {
				
				return "redirect:loginfail";
			}
		} else {
			return "redirect:loginfail";
		}
		
		
	}
	@RequestMapping("/loginfail")
	public String loginfail(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 loginfail() 메소드 실행");
		return "home";
	}
	
	@RequestMapping("/loginOK")
	public String loginOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 loginOK() 메소드 실행");
		return "main";
	}
	
//	회원가입 홈페이지 이동
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 ajaxregister() 메소드 실행");
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
		return "insertOK";
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
		
		System.out.println(request.getParameter("category"));
		System.out.println(Integer.parseInt(request.getParameter("ref")));
		
		boardVO.setCategory(request.getParameter("category"));
		boardVO.setRef(Integer.parseInt(request.getParameter("ref")));
		boardVO.setName(request.getParameter("name"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContent(request.getParameter("content"));
		System.out.println(boardVO);
		mapper.write(boardVO);
		return "main";
	}
	
	
//	사회 게시판으로 이동
	@RequestMapping("/socialBoard")
	public String newestBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 socialBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.socailCount();		// 사회 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.socailList(hmap));
//		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		return "socialBoard";
	}
	
//	연예 게시판으로 이동
	@RequestMapping("/entertainmentsBoard")
	public String enterBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 entertainmentsBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.enterCount();		// 연예 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.enterList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "entertainmentsBoard";
	}
	
//	스포츠 게시판으로 이동
	@RequestMapping("/sportsBoard")
	public String sportsBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 sorotsBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.sportsCount();		// 스포츠 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.sportsList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "sportsBoard";
	}
	
//	IT 게시판으로 이동
	@RequestMapping("/ITBoard")
	public String ITBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 ITBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.ITCount();		// IT 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.ITList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "ITBoard";
	}
	
//	게임 게시판으로 이동
	@RequestMapping("/gameBoard")
	public String gameBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 gameBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.gameCount();		// 게임 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.gameList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "gameBoard";
	}
	
//	쇼핑 게시판으로 이동
	@RequestMapping("/shoppingBoard")
	public String shoppingBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 sprotsBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.shoppingCount();		//  쇼핑 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.shoppingList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "shoppingBoard";
	}
	
//	자유 게시판으로 이동
	@RequestMapping("/freeBoard")
	public String freeBoard(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 freeBoard() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) {	}
		int totalCount = mapper.freeCount();		// 자유 게시판 글의 개수 구하기
		System.out.println(totalCount);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardList boardList = ctx.getBean("boardList", BoardList.class);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		boardList.initBoardList(pageSize, totalCount, currentPage);
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		boardList.setList(mapper.freeList(hmap));
		
		model.addAttribute("boardList", boardList);
		return "freeBoard";
	}
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 increment() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		int bidx = Integer.parseInt(request.getParameter("bidx"));
//		System.out.println(bidx);
		mapper.increment(bidx);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		model.addAttribute("bidx", bidx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:contentView";
	}
	
//	
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 contentView() 메소드 실행");
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		BoardVO boardVO = ctx.getBean("boardVO", BoardVO.class);
		System.out.println(bidx);
		boardVO = mapper.selectBybidx(bidx);
		System.out.println(boardVO);
		model.addAttribute("vo", boardVO);
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
		model.addAttribute("enter", "\r\n");
		return "contentView";
	}
	
	
}
