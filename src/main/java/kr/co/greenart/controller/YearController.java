package kr.co.greenart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String year(@RequestParam String className, Model model ) {
		
		String date = className;
		System.out.println("날짜 값은요?" + date);
		//총 고객 수
		int totalmember = service.totalmember(date);
		System.out.println("토탈라운드의 값은요?!!!!!!!!!!!!!!!!!!!!!!!!!!" +totalmember );
		model.addAttribute("totalmember", totalmember);
		//총 거래 수
		int totalRound = service.totalRound(date);
		System.out.println("토탈라운드의 값은요?!!!!!!!!!!!!!!!!!!!!!!!!!!" +totalRound );
		model.addAttribute("totalRound", totalRound);
		//총 금액
		int totalCost = service.totalCost(date);
		System.out.println("토탈라운드의 값은요?!!!!!!!!!!!!!!!!!!!!!!!!!!" +totalCost );
		model.addAttribute("totalCost", totalCost);
		
		//2022년 총 블로그 유입 수
		int nullPoint = 0;
		String blog ="블로그";
		try {
			int blogData = service.inflowBlog(date,blog);
			System.out.println("블로그의 횟수 값은 무엇인가요?" +blogData);
			model.addAttribute("blog", blogData);
		}catch(DataAccessException e) {
			model.addAttribute("blog", nullPoint);
		}
		
		//2022년 총 인스타그램 유입 수
		String instar ="인스타그램";
		try {			
			int InstarData = service.inflowBlog(date,instar);
			model.addAttribute("Instar", InstarData);
		}catch(DataAccessException e) {
			model.addAttribute("Instar", nullPoint);
		}
		
		//2022년 총 블로그 페이스북 수
		String faceBook ="페이스북";
		try {
			int faceData = service.inflowBlog(date,faceBook);
			System.out.println("페이스북 횟수 값은 무엇인가요?" +faceData);
			model.addAttribute("face", faceData);
		}catch(DataAccessException e) {
			model.addAttribute("face", nullPoint);
		}
		
		//2022년 총 지인추천 수
		String friend ="지인추천";			
		try {
			int fData = service.inflowBlog(date,friend);
			model.addAttribute("fData", fData);			
		}catch(DataAccessException e) {
			model.addAttribute("fData", nullPoint);
		}
		
		//2022년 총 기타 유입 수
		String other = "기타";
		try {
			int otherD = service.inflowBlog(date,other);
			model.addAttribute("otherD", otherD);			
		}catch(DataAccessException e) {
			model.addAttribute("otherD", nullPoint);
		}
		
		int a = 1;
		int b = 2;
		int c = 3;
		//경험고객 데이터
		int exC = service.experinceCustomer(date, a);
		System.out.println("값은 무엇인가요 exC " + exC);
		model.addAttribute("exC", exC);
		//구매고객 데이터
		int byC = service.buyCustomer(date, a, b);
		System.out.println("값은 무엇인가요 byC " + byC);
		model.addAttribute("byC", byC);
		//단골고객 데이터
		int reC = service.starinceCustomer(date, c);
		System.out.println("값은 무엇인가요 reC " + reC);
		model.addAttribute("reC", reC);
		
		return "yearView";
	}
	
	
	
}
