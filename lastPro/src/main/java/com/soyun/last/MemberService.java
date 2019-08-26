package com.soyun.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Transactional
	public void userAuth(String email) {
		memberDAO.userAuth(email);
	}
}
