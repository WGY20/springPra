package kr.co.wecky.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.wecky.dto.AdminDto;
import kr.co.wecky.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public String mainView() {
		return "/admin/main";
	}
	
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		return "/admin/create_account_form";
	}
	
	@PostMapping("/createAccountConFirm")
	public String createAccountConfirm(AdminDto adminDto) {
		System.out.println("createAccountConfirm" + adminDto.toString());
		adminService.adminInsert(adminDto);
		return "/admin/create_account_form";
	}
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/admin/login_form";
	}
	
	@PostMapping("/loginConFirm")
	public String loginConFirm(AdminDto adminDto, HttpSession session) {
		String nextPage = "/admin/login_ok";
		
//		로그인한 사용자의 dto
		AdminDto adminLoginedDto = adminService.loginConfirm(adminDto);
		
		if(adminLoginedDto == null) {
			nextPage = "/admin/login_ng";
			return nextPage;
		}
		
		if(passwordEncoder.matches(adminDto.getA_password(), adminLoginedDto.getA_password())) {
			session.setAttribute("adminLoginedDto", adminLoginedDto);
			session.setMaxInactiveInterval(60*30); // 60초 * 30 = 30분
			return nextPage;
		} else {
			nextPage = "/admin/login_ng";
			return nextPage;
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	@GetMapping("/listupAdmin")
	public String listupAdmin(Model model) {
		String nextPage = "/admin/admin_list";
				
		List<AdminDto> adminDtos = adminService.adminList();
		model.addAttribute("adminDtos", adminDtos);
		return nextPage;
	}
}
