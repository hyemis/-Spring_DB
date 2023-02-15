package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

public class MemberService {
	
	// 수정 
	public MemberVo MyInfo(String id) {
		 MemberVo result = null;
		 Connection conn = getConnection();
		 result = new MemberDao().myinfo(id);
		 close(conn);
		 return result;
	}
	
	
	// 로그인
	public MemberVo login(MemberVo vo) {
		 MemberVo result = null;
		 Connection conn = getConnection();
		 result = new MemberDao().login(conn,vo);
		 close(conn);
		 return result;
	}
	
	
	// 회원가입 
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new MemberDao().enroll(conn, vo);
		close(conn);
	
		return result;
	
	}

}
