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
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.model.DellInfo;
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
	
	
	@GetMapping(value = "/main")
	public String dell(Model model) {
		List<DellInfo> list = service.dellView();
		System.out.println("dell의 값이 잘 넘어오나요??" +list);
		model.addAttribute("list",list);
		
		return "dellAdd";
	}
	
	@GetMapping(value = "/member")
	public String member(Model model) {
		
		int a = 1;
		List<UserInfo> list =service.look(a);
		System.out.println("리스트값이 있는가??" + list);
		model.addAttribute("list",list);
		//토탈 페이지를 알려줌
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		model.addAttribute("totalpage",totalpage );
		return "memberAdd";
		
	}

	@GetMapping(value = "/view")
	public String view(@RequestParam int viewpage ,@RequestParam int number, Model model) {
		int a = viewpage;
		int d = number;
		System.out.println("디의 값이 궁금해요!!!!!!!!!!!!!!!! " + d);
		System.out.println("a의 값이 무없인지 알고 싶어요!!!!!!!!!!!!!" + a);
		List<UserInfo> list = service.look(a);
		model.addAttribute("list", list);
		
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
		model.addAttribute("a",d);			
		
		return "memberAdd";
	}
		
	@GetMapping(value = "/coutView")
	public String list(@RequestParam int page ,Model model) {
		//a=1
		int a = page; 
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"+a);
			System.out.println("값이 잘 들어오는지요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			List<UserInfo> list = service.look(a);	
			int result = service.total();
			int totalpage = (int)Math.ceil(result/10.0);
			model.addAttribute("list", list);
			System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
			
			model.addAttribute("totalpage",totalpage );			
			int b = a+1;
			System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + b);
			model.addAttribute("a", b);
		
		
		return "memberAdd";
		
	}
	
	@GetMapping(value = "/maius")
	public String mius(@RequestParam int maius ,Model model) {
		
		int a = maius;

		List<UserInfo> list = service.look(a+2);
		model.addAttribute("list", list);
		
		int result = service.total();
		int totalpage = (int)Math.ceil(result/10.0);
		
		System.out.println("이 숫자를 알려주세요!!!!!!!!!!!!!!!!!!" +totalpage);
		
		model.addAttribute("totalpage",totalpage );
			
		
		System.out.println("이값이 맞을까요 !!!!!!!!!!!!!!!!!!!!!!!" + a);
		model.addAttribute("a", a);
		
		return "memberAdd";
		
	}
	
	

	
	
}
