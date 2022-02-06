package kr.co.greenart.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.UserInfo;
import kr.co.greenart.repository.lWriteDao;
import kr.co.greenart.service.IJoinAndLoginService;
import kr.co.greenart.service.IWriteService;
import kr.co.greenart.service.JoinAndLoginService;
import kr.co.greenart.validator.JoinVlidator;

@Controller
@RequestMapping("/write")
public class WriteController {
	private Logger logger = LoggerFactory.getLogger(WriteController.class);
	
	@Autowired
	private IWriteService servicess;
	
	@Autowired
	private memberViewController serviceLook;

	@Autowired
	private JoinAndLoginService services;
	
	@Autowired
	private lWriteDao service;
	
	
	@GetMapping(value = "/writing")
	public String write() {
		return "write";
	}
	
	//고객 이름을 클릭한 뒤 고객정보가 나오게 하는 페이지 처리
	@GetMapping(value = "/dellWrite")
	public String dellwrite() {
		return "dellWrite";
	}

	
	//회원정보 추가 페이지에서 회원을 추가 해주는 역할
	@PostMapping("/userAdd")
	public String add(UserInfo user, Model model ) {
		logger.info(user.toString());
		//중복된 이름이 작성되지 않도록 중복버튼을 설정하던가
		//오류 페이지를 가지고 alert 창을 띄는 방법을 해야함.
		List<UserInfo> list =servicess.look();
		System.out.println("리스트값이 있는가??" + list);
		model.addAttribute("list",list);
		int userPk =services.pickId;
		service.add(user,userPk);
		
		return "memberInfo";
	}
	
	//고객 정보 페이지에서 거래등록을 해주는 역할
	
	@PostMapping("/classAdd")
	public String dellAdd(ClassInfo classInfo) {
		logger.info(classInfo.toString());
		int userId = serviceLook.id;
		service.ClassInfoAdd(classInfo,userId);
		
		return "memberInfo";
	}
	
}
