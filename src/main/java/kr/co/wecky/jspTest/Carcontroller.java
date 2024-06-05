package kr.co.wecky.jspTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class Carcontroller {
	
	@GetMapping("/car/step1")
	public String car_Test_01() {
		return "/jsp-test/step1";
	}
	
	@GetMapping("/step1-if")
	public String step_01() {
		return "/jsp-test/step1-if";
	}
	
	@GetMapping("/step2")
	public String step_02(Model model) {
		Person dto = new Person("손흥민", 30);
		model.addAttribute("dto", dto);
		return "/jsp-test/step2-choose";
	}
}
