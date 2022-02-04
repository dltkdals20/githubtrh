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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.UserInfo;
import kr.co.greenart.repository.lWriteDao;
import kr.co.greenart.service.IJoinAndLoginService;
import kr.co.greenart.validator.JoinVlidator;

@Controller
@RequestMapping("/view")
public class memberViewController {
	private Logger logger = LoggerFactory.getLogger(memberViewController.class);
	public static int id;
	
	@Autowired
	private lWriteDao service;
	
	
	@GetMapping(value = "/memberview")
	public String view(@RequestParam int bbsID, Model model) {
		
		id = bbsID;
		//이상민 이름,나이 정보 가져오는 서비스
		UserInfo list =service.UserNameAndAge(id);
		//이상민 총 금액 가져오는 서비스
		int totalCost = service.totalCost(id); 
		System.out.println("금액이 잘 넘어오나요!!!!!!!!!!!!!" + totalCost);
		//고객세부사항 전체 글 보여주는 서비스
		List<ClassInfo> classInfo = service.classTotal(id);
		//이상민 총 수업 횟수 가져오는 서비스
		int totalRound = service.totalRound(id);
		model.addAttribute("list", list);
		model.addAttribute("cost", totalCost);
		model.addAttribute("round", totalRound);
		model.addAttribute("total", classInfo);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +list);
		
		return "memberInfo";
	}
	

	
	
	
	
	
}
