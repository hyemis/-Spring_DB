package kh.member.model.vo;

/**
 * 
 * @author hyemijo
 *  TEST_MEMBER 테이블을 이용
 * 0. 첫화면("/")-index.jsp header include header.jsp - 로그인(login Get)/로그아웃(logout Get) 버튼 토글, nav 내 정보(myinfo get) 보기 
 * 로그인 화면 - 로그인 버튼(login Post) / 회원가입 버튼 (enroll Get) 
 * 1. 회원가입("/enroll") - get enroll.jsp, post 회원 가입 DB 다녀와서 첫화면으로 이동 
 * 회원가입화면 - 회원 가입(enroll post) 버튼
 * 2. 로그인 ("/login") - Get login.jsp로 forward, Post 로그인 DB 다녀와서 session("lgnss") 등록 (이름, email, id) 완료 후 첫화면 이동
 * 3. 로그아웃 ("/logout") - Get 세션 만료 후 / 이동 
 * 4. 내 정보 보기 ("/myinfo") -  get myinfo.jsp 
 * 내 정보 보기 화면에서 하단에 수정(infoupdate Get), 탈퇴 버튼
 * 5. 내 정보 수정 ("/infoupdate")
 * 내 정보 보기 수정 화면에서 수정(infoupdate post)
 */

public class MemberVo {

	/*
	이름     널?       유형           
			------ -------- ------------ 
			ID     NOT NULL VARCHAR2(15) 
			PASSWD NOT NULL VARCHAR2(15) 
			NAME   NOT NULL VARCHAR2(20) 
			EMAIL           VARCHAR2(30) 

	*/
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
