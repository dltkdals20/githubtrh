package kr.co.greenart.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.UserInfo;
import kr.co.greenart.service.IWriteService;
import kr.co.greenart.service.JoinAndLoginService;
import kr.co.greenart.validator.JoinVlidator;

@Controller
@RequestMapping("/main")
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IWriteService service;
	
	
	@Autowired
	private JoinVlidator validator;
	
	@GetMapping(value = "/main")
	public String dell() {
		return "dellAdd";
	}
	@GetMapping(value = "/member")
	public String member(Model model) {
		
		List<UserInfo> list =service.look();
		System.out.println("리스트값이 있는가??" + list);
		
		model.addAttribute("list",list);
		
		return "memberAdd";
	}
	
	

	
	
}
