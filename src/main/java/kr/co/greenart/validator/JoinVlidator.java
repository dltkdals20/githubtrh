package kr.co.greenart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.greenart.model.JoinInfo;



@Component
public class JoinVlidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(JoinInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target == null) {
			errors.reject("JoinInfo.null","������ �����ϴ�.");
		}
		
		JoinInfo user = (JoinInfo) target;
		
		ValidationUtils.rejectIfEmpty(errors, "userId", "userId.empty", "���̵� �Է����ּ���");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "��й�ȣ�� �Է����ּ���");
		ValidationUtils.rejectIfEmpty(errors, "name","name.empty", "�̸��� �Է����ּ���");
		ValidationUtils.rejectIfEmpty(errors, "phone","phone.empty", "�ڵ��� ��ȣ�� �Է����ּ���");
		
	}

}
