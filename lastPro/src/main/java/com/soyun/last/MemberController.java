package com.soyun.last;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.mail.JinsMail;

import jdk.nashorn.internal.ir.annotations.Reference;

@Controller
public class MemberController {

	@Autowired
	MemberDAO memberDAO;
	MemberTools tool = new MemberTools();
	
	@RequestMapping("loginPage")
	public void loginPage(Model model) {
		model.addAttribute("loginPage",tool.login());
	}
	
	@RequestMapping("sign")
	public void sign() {}
	
	@RequestMapping("insert")
	public void insert(MemberDTO memberDTO) {
		memberDTO.setAuthKey('0');
		memberDTO.setTotaddr();
		memberDTO.setName(memberDTO.getName());
		memberDAO.insert(memberDTO);
		//인증메일보내기
		JinsMail mail = new JinsMail();
		mail.setId("leesoyun702");
		mail.setPw("verycuteso0425");
		mail.setSndUsr("이소윤", "leesoyun702@gmail");
		String id = "\"http://localhost:8899/last/authkey?id="+memberDTO.getId()+"\"";
		mail.SendMail(memberDTO.getEmail(), "가입완료 메일입니다.", "<a href="+id+">회원가입 인증하기</a>");
	}
	
	@RequestMapping("selectId")
	public void selectId(String id,Model model) {
		if(memberDAO.select(id)!=null) {
			model.addAttribute("result","중복됨");
		}else {
			model.addAttribute("result","중복안됨");
		}
	}
	
	@RequestMapping("delete")
	public void delete(MemberDTO memberDTO) {
		memberDAO.delete(memberDTO);
	}
	
	@RequestMapping("selectAll")
	public void selectAll(Model model) {
		List<MemberDTO> list = memberDAO.selectAll();
		model.addAttribute("list", list);
	}
	//인증키 인증된 처리
	@RequestMapping("authkey")
	public void authkey(String id) {
		if('0'==(memberDAO.select(id).getAuthkey()))
			memberDAO.update(id);
		else
			System.out.println("나중에 이미 인증됐을 경우 홈으로 돌려보내는 처리 할 장소");
	}
	//로그인하기
	@RequestMapping("login")
	public String login(String id, String pw,HttpServletResponse response,Model model) throws IOException {
		MemberDTO dto = memberDAO.select(id);
		char authkey = memberDAO.select(id).getAuthkey();
		if(dto!=null) {
			if(pw.equals(dto.getPw())) {
				if(authkey=='0') {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script type='text/javascript'>");
					out.println("alert('인증되지 않은 아이디입니다!!이메일에서 확인 후 로그인해주세요.')");
					out.println("</script>");
					out.flush();
					model.addAttribute("loginPage",tool.login());
					return "loginPage";
				}
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('로그인 성공!!')");
				out.println("</script>");
				out.flush();
				return "success";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('비밀번호 틀렸어요!!')");
				out.println("</script>");
				out.flush();
				return "loginPage";
			}
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('없는 아이디 입니다.')");
			out.println("</script>");
			out.flush();
			return "loginPage";
		}
	}
	//아이디 찾기
	@RequestMapping("searchId")
	public void searchId() {}
	@RequestMapping("findId")
	public void findId(MemberDTO memberDTO) {
		MemberDTO dto = memberDAO.selectId(memberDTO);
		JinsMail mail = new JinsMail();
		mail.setId("leesoyun702");
		mail.setPw("verycuteso0425");
		mail.setSndUsr("이소윤", "leesoyun702@gmail");
		mail.SendMail(memberDTO.getEmail(), "찾으신 아이디입니다.","찾으신 아이디는 "+"<h2>"+dto.getId()+"</h2>"+"입니다.");
	}
	
	//비밀번호 찾기
	@RequestMapping("searchPw")
	public void searchPw() {}
	@RequestMapping("findPw")
	public void findPw(MemberDTO memberDTO) {
		MemberDTO dto = memberDAO.selectPw(memberDTO);
		JinsMail mail = new JinsMail();
		String pw = "\"http://localhost:8899/last/updatePw?id="+dto.getId()+"\"";
		mail.setId("leesoyun702");
		mail.setPw("verycuteso0425");
		mail.setSndUsr("이소윤", "leesoyun702@gmail");
		mail.SendMail(dto.getEmail(), "비밀번호 변경메일 입니다.","<a href="+pw+">비밀번호 변경하기</a>");
	}
	
	//비밀번호 찾고 변경하기
	@RequestMapping("updatePw")
	public void updatePw(MemberDTO memberDTO,Model model) {
		String id = memberDTO.getId();
		MemberDTO dto = memberDAO.select(id);
		model.addAttribute("id",dto.getId());
	}
	@RequestMapping("updatePw2")
	public void updatePw2(MemberDTO memberDTO) {
		memberDAO.updatePw(memberDTO);
	}
}
