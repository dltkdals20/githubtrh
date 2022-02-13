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
import kr.co.greenart.service.IWriteService;
import kr.co.greenart.service.JoinAndLoginService;
import kr.co.greenart.service.WriteService;
import kr.co.greenart.validator.JoinVlidator;

@Controller
@RequestMapping("/view")
public class memberViewController {
	private Logger logger = LoggerFactory.getLogger(memberViewController.class);
	public static int id;
	
	@Autowired
	private lWriteDao service;
	
	@Autowired
	private IWriteService WriteService;
	
	
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
		
	}
	//고객세부정보에서 등록 버튼을 누른 후 클래스이름,날짜,금액,내용등을 입력하고 등록을 누르게되면 실행되는 메소드
	@PostMapping("/classAdd")
	public String dellAdd(ClassInfo classInfo, Model model) throws ParseException {
		System.out.println("정보가 다 넘어오는지!!!!!!!!!!!!!!!!!!!"+classInfo);
		logger.info(classInfo.toString());
		int userId =id;
		//고객이 작성한 클래스이름,가격,날짜,내용 정볼르 추가하는 서비스
		service.ClassInfoAdd(classInfo,userId);
		//추가를 한 뒤 다시 내용을 보여줘야 함.
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
			List<ClassInfo> classInfos = service.classTotal(id);
			
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
			model.addAttribute("total", classInfos);
			model.addAttribute("day", diffDays);
			return "memberInfo";
		}else {
			
			return "memberInfo";
		}
		
	
	}
	
	
	//회원정보 세부사항에서 회원정보 전체 삭제를 누리게 되면 회원정보가 전체 삭제되는 기능
	//1.회원정보 전체 삭제는 memberAdd 이름,나이,내용도 삭제 되어야 함
	//2.memberInfom에 있는 회원정보도 삭제가 되어야 함.
	//넘어오는 id 인덱스 값으로 meemberAdd,memberInfo 값을 삭제를 함.

	@GetMapping("/delete")
	public String delete(Model model) {
		int userpk = id;
		
		//classInfo에 값이 없는 경우. count값으로 조회를 먼저 하면 됨
		
		int idCheck = service.idCheck(userpk);
		
		if(idCheck == 0) {
			//count 값이 0이면 infoDlete 삭제 쿼리문 실행하지 않음
			//addDelete 삭제 쿼리 구문만 실행
			int addDelete=  service.addDelet(userpk);
			
			//삭제를 하고 나서 다시 memberAdd jsp를 보여줘야 함
			// 삭제한 회원정보를 제외하고 다른 회원정보를 보여줌.
		//memberAdd에 회원정보 이름,나이,날짜 내용들의 리스트를 보여줌.
			List<UserInfo> list =WriteService.look();
			System.out.println("리스트값이 있는가??" + list);
			
			model.addAttribute("list",list);
			
			
		}else {
			//memberInfo 삭제 쿼리문 실행
			int infoDelete= service.infoDelet(userpk);
			//addDelete 삭제 쿼리 구문 실행
			int addDelete=  service.addDelet(userpk);	
			
			//삭제를 하고 나서 다시 memberAdd jsp를 보여줘야 함
			// 삭제한 회원정보를 제외하고 다른 회원정보를 보여줌.
		//memberAdd에 회원정보 이름,나이,날짜 내용들의 리스트를 보여줌.
			List<UserInfo> list =WriteService.look();
			System.out.println("리스트값이 있는가??" + list);
			
			model.addAttribute("list",list);
		}
			
		
		return "memberAdd";

	}
	
	
	
	
}
