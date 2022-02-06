package kr.co.greenart.controller;





import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import kr.co.greenart.model.CostInfo;
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
	public String view(@RequestParam int bbsID, Model model) throws ParseException {
		
		//memberId
		id = bbsID;
		//이상민 이름,나이 정보 가져오는 서비스
			UserInfo list =service.UserNameAndAge(id);
			model.addAttribute("list", list);
			//조건문을 활용하면 되겠죠? 
			//totalCost 값이 널이면 통과를 못하고 totalCost 가 값이 있으면 통과
			//이상민 총 금액 가져오는 서비스
			int totalCost = service.totalCost(id); 
			System.out.println("값은 무엇인가요?!!!!!!!!!!!!!!!!!!!!!!" +totalCost);
			if(totalCost != 0) {
				
				DecimalFormat decFormat = new DecimalFormat("###,###");
				String str = decFormat.format(totalCost);
				//고객세부사항 전체 글 보여주는 서비스
				List<ClassInfo> classInfo = service.classTotal(id);
				
				//오늘 현재 날짜
				LocalDate now = LocalDate.now();
				String nowday = now.toString();
				System.out.println("현재 날짜는요" + nowday);
				//이상민 고객의 최근 구매 날짜
				String buyDate = service.buyDate(id);
				System.out.println("값이 어찌도나요??" + buyDate);
				
				
				Calendar getToday = Calendar.getInstance();
				getToday.setTime(new Date()); //금일 날짜
				
				String s_date = buyDate;
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s_date);
				Calendar cmpDate = Calendar.getInstance();
				cmpDate.setTime(date); //특정 일자
				
				long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
				long diffDays = diffSec / (24*60*60); //일자수 차이
				//구매횟수
				int totalRound = service.totalRound(id);
				
				model.addAttribute("cost", str);
				model.addAttribute("round", totalRound);
				model.addAttribute("total", classInfo);
				model.addAttribute("day", diffDays);
				return "memberInfo";
			}else {
				
				return "memberInfo";
			}

		
		
		
		//이상민 총 수업 횟수 가져오는 서비스
		
		
		
	}
	

	
	
	
	
	
}
