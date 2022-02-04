package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.service.IJoinAndLoginService;
import kr.co.greenart.validator.LoginVlidator;

@Controller
@RequestMapping("/mapping")
public class loginController {
	private Logger logger = LoggerFactory.getLogger(loginController.class);

	@Autowired
	private IJoinAndLoginService service;

	@Autowired
	private LoginVlidator validators;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@ModelAttribute
	public LoginInfo loginInfo() {
		LoginInfo login = new LoginInfo();
		return login;
	}

	@PostMapping("/login")
	public ModelAndView add(@ModelAttribute LoginInfo user, HttpSession session) {
		logger.info(user.toString());

		boolean results = service.logincheck(user, session);
		ModelAndView mav = new ModelAndView();

		if (results == true) {
			mav.setViewName("main");
			mav.addObject("msg", "success");
		} else {
			mav.setViewName("login");
			mav.addObject("msg", "failure");
		}

		return mav;



	}

}
