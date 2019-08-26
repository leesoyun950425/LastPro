package com.soyun.last;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String birth;
	private char authkey;
	private String roadaddr;
	private String totaddr;
	private String addr1;
	private String addr2;
	private String addr3;
	private String addr4;
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
		setRoadaddr(addr2);
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public void setAddr4(String addr4) {
		this.addr4 = addr4;
		
	}
	public String getRoadaddr() {
		return roadaddr;
	}
	public void setRoadaddr(String roadaddr) {
		this.roadaddr = roadaddr;
	}
	public String getTotaddr() {
		return totaddr;
	}
	public void setTotaddr() {
		this.totaddr = addr1+addr2+addr3+addr4;
	}
	public void setAuthkey(char authkey) {
		this.authkey = authkey;
	}
	public char getAuthkey() {
		return authkey;
	}
	public void setAuthKey(char authkey) {
		this.authkey = authkey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
