package com.icia.membership.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.membership.dto.MembershipDTO;
import com.icia.membership.service.MembershipService;


@Controller
public class MembershipController {
	
	@Autowired
	private MembershipService ms;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		System.out.println("joinpage 컨트롤러");
		return "memberjoin";
	}
	
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		System.out.println("idcheck 컨트롤러");
		String result = ms.idCheck(mid);
		
		return result;
	}
	
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MembershipDTO membership)throws IllegalStateException, IOException {
		System.out.println("멤버컨트롤러 멤버조인");
		mav=ms.memberJoin(membership);
		
		return mav;
	}
	
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView memberLogin(@ModelAttribute MembershipDTO membership) {
		mav=ms.memberLogin(membership);
		return mav;
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		session.invalidate();
		return "home";
	}

	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav=ms.memberList();
		
		return mav;
	}
	
	@RequestMapping(value="/memberviewAjax")
	public @ResponseBody MembershipDTO memberViewAjax(@RequestParam("mid") String mid) {
		MembershipDTO membership = ms.memberViewAjax(mid);
		return membership;
	}
	
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav=ms.update();
		return mav;
	}

	@RequestMapping(value="/memberupdateprocess")
	public ModelAndView updateProcess(@ModelAttribute MembershipDTO membership) {
		mav=ms.updateProcess(membership);
		return mav;
	}
	
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav=ms.memberView(mid);
		return mav;
	}
	
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav=ms.memberDelete(mid);
		return mav;
	}
	
	@RequestMapping(value="/membermain")
	public String mamberMain() {
		return "membermain";
	}
}