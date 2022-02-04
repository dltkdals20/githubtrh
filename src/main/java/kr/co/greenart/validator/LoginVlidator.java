package kr.co.greenart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.greenart.model.LoginInfo;

@Component
public class LoginVlidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(LoginInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target == null) {
			errors.reject("LoginInfo.null", "정보가 없습니다.");
		}
		
		LoginInfo login = (LoginInfo) target;
		
		ValidationUtils.rejectIfEmpty(errors,"userId", "userId.empty","아이디를 입력해주세요");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "비밀번호를 입력해주세요");
	}

}
