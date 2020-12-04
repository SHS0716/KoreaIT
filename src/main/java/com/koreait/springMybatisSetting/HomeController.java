package com.koreait.springMybatisSetting;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.dao.MybatisDAO;
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
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 login() 메소드 실행");
		return "list";
	}
	
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 join() 메소드 실행");
		return "join";
	}
	
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
	
}
