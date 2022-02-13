package kr.co.greenart.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.DellInfo;
import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.repository.lWriteDao;

@Controller
@RequestMapping("/dell")
public class DellWriteController {

	private Logger logger = LoggerFactory.getLogger(DellWriteController.class);

	@Autowired
	private lWriteDao service;

	@PostMapping(value = "/dellWrite")
	public String dellWrite(@RequestParam String start, String end, Model model) {
		System.out.println("값이 잘 전달 해 왔는지?" + start);
		System.out.println("값이 뭘까요?" + end);
		String startDate = start;
		String endDate = end;

		// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터
		List<DellInfo> list = service.dateView(startDate, endDate);
		model.addAttribute("list", list);

		// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 총 금액
		int cost = service.totalCost(startDate, endDate);
		model.addAttribute("cost", cost);

		// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 횟수
		int round = service.totalRound(startDate, endDate);
		model.addAttribute("round", round);

		// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 유입경로 데이터
		//key:블로그 value:2,key:인스타그램 value:3,key:페이스북 value:4,key:지인추천 value:4
		//이런 형태로 오기 위해서는 일단 list로 값을 받아온 뒤.
		//특정 이름,값을 넣기 위해서는 map을 선언을 하고 map에 다가 키 벨류 형태로 담아 jsp파일로 던져줍니다.
		List<InflowInfo> results = service.totalInflow(startDate, endDate);
		System.out.println("값은 무엇인가요 result " + results.toString());
		int nullPoint = 0;
		String blog ="블로그";
		try {
			int blogData = service.inflowBlog(startDate,endDate,blog);
			System.out.println("블로그의 횟수 값은 무엇인가요?" +blogData);
			model.addAttribute("blog", blogData);
		}catch(DataAccessException e) {
			model.addAttribute("blog", nullPoint);
		}
	
		String instar ="인스타그램";
		try {			
			int InstarData = service.inflowBlog(startDate,endDate,instar);
			model.addAttribute("Instar", InstarData);
		}catch(DataAccessException e) {
			model.addAttribute("Instar", nullPoint);
		}
	
		String faceBook ="페이스북";
		try {
			int faceData = service.inflowBlog(startDate,endDate,faceBook);
			System.out.println("페이스북 횟수 값은 무엇인가요?" +faceData);
			model.addAttribute("face", faceData);
		}catch(DataAccessException e) {
			model.addAttribute("face", nullPoint);
		}
	
		String friend ="지인추천";			
		try {
			int fData = service.inflowBlog(startDate,endDate,friend);
			model.addAttribute("fData", fData);			
		}catch(DataAccessException e) {
			model.addAttribute("fData", nullPoint);
		}
		
		String other = "기타";
		try {
			int otherD = service.inflowBlog(startDate,endDate,other);
			model.addAttribute("otherD", otherD);			
		}catch(DataAccessException e) {
			model.addAttribute("otherD", nullPoint);
		}
		
		return "dellAdd";

	}
}

//맵을 써서 키 벨류 형식으로 jsp에 보내서 읽으려고 햇지만, jsp에서 읽는 부분에서 실패를 함.
//HashMap<String,Object> map = new HashMap<>();
//for (InflowInfo inflowInfo : results) {
//	System.out.println("inflowInfo 값은" +inflowInfo.getInflow());
//	System.out.println("inflowInfo 값은" +inflowInfo.getCount());
//	map.put(inflowInfo.getInflow(), inflowInfo.getCount());			
//}	
//	model.addAttribute("key", map);
//	

//List<Map<String,Object>> 키 벨류값 꺼낼때 쓰는 것.

//for (Map<String, Object> map : resultMap) {
//	for (Map.Entry<String, Object> entry : map.entrySet()) {
//		String key = entry.getKey();
//		Object value = entry.getValue();
//		System.out.println("key: " + key + " | value: " + value);
//	}
//
//}
