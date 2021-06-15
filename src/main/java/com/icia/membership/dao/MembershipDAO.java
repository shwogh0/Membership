package com.icia.membership.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.membership.dto.MembershipDTO;

@Repository
public class MembershipDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int memberJoin(MembershipDTO membership) {
		return sql.insert("mm.memberjoin", membership);
	}

	public String idCheck(String mid) {
		return sql.selectOne("mm.idcheck",mid);
	}

	public String memberLogin(MembershipDTO membership) {
		return sql.selectOne("mm.memberlogin",membership);
	}

	public List<MembershipDTO> memberList() {
		return sql.selectList("mm.memberlist");
	}

	public MembershipDTO update(String loginId) {
		return sql.selectOne("mm.memberupdate", loginId);
	}

	public int updateProcess(MembershipDTO membership) {
		return sql.update("mm.updateprocess",membership);
	}

	public MembershipDTO memberView(String mid) {
		return sql.selectOne("mm.memberview",mid);
	}

	public void memberDelete(String mid) {
		sql.delete("mm.memberdelete", mid);
		
	}

}









