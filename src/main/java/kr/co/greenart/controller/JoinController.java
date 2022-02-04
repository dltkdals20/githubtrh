package kr.co.greenart.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.service.IJoinAndLoginService;
import kr.co.greenart.validator.JoinVlidator;

@Controller
@RequestMapping("/paths")
public class JoinController {
	private Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private IJoinAndLoginService service;
	
	@Autowired
	private JoinVlidator validator;
	
	@GetMapping(value = "/join")
	public String join() {
		return "join";
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(validator);
	}

	@ModelAttribute
	public JoinInfo joinInfo() {
		JoinInfo user = new JoinInfo();
		return user;
	}
	
	@PostMapping("/join")
	public String add(@ModelAttribute @Valid JoinInfo user ,BindingResult result ) {
		logger.info(user.toString());
		if(result.hasErrors()) {
			return "join";
		}
		service.add(user);
		
		return "redirect:/";
	}
	
	
}
