package com.soyun.last;

import java.util.List;

import javax.mail.Session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public void insert(MemberDTO memberDTO) {
		mymy.insert("memberDAO.insert",memberDTO);
	}
	
	public MemberDTO select(String inputId) {
		return mymy.selectOne("memberDAO.select",inputId);
	}
	
	public MemberDTO selectId(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectId",memberDTO);
	}
	public void update(String id) {
		mymy.update("memberDAO.update",id);
	}
	public void updatePw(MemberDTO memberDTO) {
		mymy.update("memberDAO.updatePw",memberDTO);
	}
	
	public void delete(MemberDTO memberDTO) {
		mymy.delete("memberDAO.delete",memberDTO);
	}
	
	public List<MemberDTO> selectAll(){
		return mymy.selectList("memberDAO.selectAll");
	}
	
	public void userAuth(String email) {
		mymy.update("memberDAO.memberAuth", email);
	}
}
