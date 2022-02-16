package kr.co.greenart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.repository.lWriteDao;
import kr.co.greenart.repository.lYearCountSerivceDao;


@Controller
@RequestMapping("/year")
public class YearController {
	
	@Autowired
	private lYearCountSerivceDao service;
	
	@GetMapping(value = "/yearCount")
	public String join() {
		return "yearView";
	}
	
	@PostMapping("/yearPost")
	public String year(@RequestParam String className ) {
		
		String date = className;
		System.out.println("날짜 값은요?" + date);
		int totalRound = service.totalRound(date);
		System.out.println("토탈라운드의 값은요?!!!!!!!!!!!!!!!!!!!!!!!!!!" +totalRound );
		return "yearView";
	}
	
	
	
}
