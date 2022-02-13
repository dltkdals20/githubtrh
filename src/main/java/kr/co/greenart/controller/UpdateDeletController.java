package kr.co.greenart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.UserInfo;
import kr.co.greenart.repository.lWriteDao;
import kr.co.greenart.service.IWriteService;

@Controller
@RequestMapping("/update")
public class UpdateDeletController {
	public static int pk;
	@Autowired
	private lWriteDao service;

	@Autowired
	private IWriteService WriteService;
	
	@GetMapping("/updating")
	public String userInfoUpdate(@RequestParam int bbsID, Model model) {
		pk = bbsID;
		ClassInfo list = service.userClass(pk);
		System.out.println("클래스값이 정확히 들어오나요??" + list);
		model.addAttribute("list", list);
		return "dellWriteAtion";

	}

	@ModelAttribute
	public ClassInfo classInfo() {
		ClassInfo info = new ClassInfo();
		return info;
	}

	@PostMapping("/infoUpdate")
	public String add(@ModelAttribute ClassInfo info,Model model) {
		System.out.println("클래스값이 정확히 들어오나요??" + info);
		int result = service.Update(info, pk);
		// memberAdd에 회원정보 이름,나이,날짜 내용들의 리스트를 보여줌.
		List<UserInfo> list = WriteService.look();
		System.out.println("리스트값이 있는가??" + list);

		model.addAttribute("list", list);

		return "memberAdd";

	}

}
