package org.kosta.springmvc20.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc20.model.dao.MemberDAO;
import org.kosta.springmvc20.model.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc9 에서 적용했던 인증여부에 따른 처리는 
 * Intercaptor를 적용해 일괄처리했으므로
 * enterCafe 와 update 관련 메서드에서 인증여부를 체크하는 로직은 필요없다
 * @author Jaeyoung
 *이거뭐야,,... 하고 있는데~
 */
@Controller
public class MemberController {
	@Resource
	private MemberDAO memberDAO;
	@RequestMapping("test.do")
	public String test(){
		return "result";
	}
	
	@RequestMapping("index.do")
	public String index(){
		return "index";
	}
	
	@RequestMapping("register.do")
	public String register(){
		return "register";
	}
	
	
	@RequestMapping("addressList.do")
	public ModelAndView getAddressList(){
		List<String> list = memberDAO.getAddressList();
		return new ModelAndView("member/addressList","list",list);
	}
	@RequestMapping("findMemberListByAddress.do")
	@ResponseBody
	public List<MemberVO> findMemberListByAddress(String address){
		return memberDAO.findMemberListByAddress(address);
	}
	
	@RequestMapping(value = "loginForm.do", method = RequestMethod.POST)
	public ModelAndView loginForm(MemberVO vo, HttpServletRequest request) {
		MemberVO mvo = memberDAO.loginForm(vo);
		if (mvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);
			return new ModelAndView("member/admin/login");
		} else {
			return new ModelAndView("login_fail");
		}
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){		
			HttpSession session=request.getSession(false);
			if(session!=null)
				session.invalidate();
			return "redirect:home.do";
	}
}


















