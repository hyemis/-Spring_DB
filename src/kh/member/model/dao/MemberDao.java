package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	// enroll ctrl -> 회원가입하기 위함. 
	// insert  - 리턴 int
	// 회원가입 
	public int enroll(Connection conn,MemberVo vo) {
		int result = -1;
		
		// 쿼리문 
		String query = "insert into Test_Member values ";
		query += " (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			// ? 가 있다면 채우주기 
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());

			// pstm 실행 
			// 결과값 result에 대입  
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("DAO enroll() return: "+ result);
		return result;
	}
	
}
