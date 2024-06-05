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
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.regexp.internal.recompile;

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
	
	@GetMapping("/setAdminApproval")
	public String setAdminApproval(@RequestParam("id") String id) {
		String nextPage = "redirect:/admin/admin_list";
		int result = adminService.updateAdminAccount(id);
		return nextPage;
	}
	
	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpSession session) {
		
		String nextPage = "/admin/modify_account_form";
		
		AdminDto adminLoginedDto = (AdminDto)session.getAttribute("adminLoginedDto");
//		현재 로그인 상태인지 확인
		if (adminLoginedDto != null) {
//		로그인 상태 : 수정 페이지로 이동		
			return nextPage;
		} else {
//		로그 아웃 상태 (세션 만료) : 로그인 페이지로 이동	
			nextPage = "/admin/login_form";
			return nextPage;
		}
	}
	
	@PostMapping("/modifyAccountConFirm")
	public String modifyAccountConFirm(AdminDto adminDto, HttpSession session) {
		AdminDto adminLoginedDto = (AdminDto)session.getAttribute("adminLoginedDto");
		
		adminService.updateAdmin(adminDto);
		
//		수정 후 관리자 리스트 페이지로 이동
		
		return "redirect:/admin/listupAdmin";
	}
	
	@GetMapping("/searchAdminConfirm")
	public String searchKeyword(@RequestParam("category") String category,
							@RequestParam("keyword") String keyword,
							Model model) {
		
		List<AdminDto> adminDtos = adminService.searchAdmin(category, keyword);
	    model.addAttribute("adminDtos", adminDtos);
      return "/admin/admin_list";
    }
	
	@GetMapping("/handlerInterceptor")
	public String handlerInterceptor() {
		return "/admin/handlerInterceptor";
	}
	

}
	























