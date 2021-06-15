package com.icia.membership.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.membership.dto.MembershipDTO;
import com.icia.membership.dao.MembershipDAO;
import com.icia.membership.dto.MembershipDTO;

@Service
public class MembershipService {
	
	@Autowired
	private MembershipDAO mdao;
	
	private ModelAndView mav;

	@Autowired
	private HttpSession session;
	
	public ModelAndView memberJoin(MembershipDTO membership)throws IllegalStateException, IOException {
		mav = new ModelAndView();
		System.out.println("멤버조인 서비스");
		
		MultipartFile mfile = membership.getMfile();
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath = "C:\\Users\\user\\Documents\\souse_njh\\spring\\Membership (4)\\src\\main\\webapp\\resources\\"+mfilename;
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		membership.setMfilename(mfilename);
		
		System.out.println("서비스 멤버조인");
		System.out.println(mfilename);
		
		int insertResult = 0;
		insertResult = mdao.memberJoin(membership);
		if(insertResult > 0) {	
			mav.setViewName("memberlogin");
		}
		
		return mav;
	}

	public String idCheck(String mid) {
		String checkResult = mdao.idCheck(mid);
		
		String result = "";
		if(checkResult == null) {
			result = "ok";
		}else {
			result = "no";
		}
		System.out.println("서비스클래스 체크결과" + result);
		return result;
	}

	public ModelAndView memberLogin(MembershipDTO membership) {
		mav = new ModelAndView();
		
		String loginId = mdao.memberLogin(membership);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/boardlist");
		} else {
			mav.setViewName("memberlogin");
		}
		return mav;
	}

	public ModelAndView memberList() {
		mav=new ModelAndView();
		List<MembershipDTO> memberList = mdao.memberList();
		
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist");
		
		return mav;
	}

	public ModelAndView update() {
		mav=new ModelAndView();
		
		String loginId = (String) session.getAttribute("loginMember");
		
		MembershipDTO memberUpdate = mdao.update(loginId);
		
		mav.addObject("member", memberUpdate);
		mav.setViewName("memberupdate");
		
		return mav;
	}

	public ModelAndView updateProcess(MembershipDTO membership) {
		mav=new ModelAndView();
		
		int updateResult = mdao.updateProcess(membership);
		if(updateResult > 0) {
			mav.setViewName("membermain");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}

	public ModelAndView memberView(String mid) {
		mav=new ModelAndView();
		
		MembershipDTO membership = mdao.memberView(mid);
		
		mav.addObject("result", membership);
		mav.setViewName("memberview");
		return mav;
	}

	public ModelAndView memberDelete(String mid) {
		mav=new ModelAndView();
		mdao.memberDelete(mid);
		mav.setViewName("redirect:/memberlist");
		
		return mav;
	}

	public MembershipDTO memberViewAjax(String mid) {
		MembershipDTO membership = mdao.memberView(mid);
		return membership;
	}

}












