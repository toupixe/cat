package com.wyd.cat.webutils.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImplements implements InitializingBean {

	private Validator validator;
	
	/**实现校验方法并返回校验结果*/
	public BeanValidator valitador(Object bean) {
		BeanValidator beanValidator = new BeanValidator();
		Set<ConstraintViolation<Object>> cons =  validator.validate(bean);
		if (cons != null && cons.size() > 0) {
			beanValidator.setHasError(true);
			cons.forEach(con -> {
				String errorMsg = con.getMessage();
				String field  = con.getPropertyPath().toString();
				beanValidator.getErrorMsgMap().put(field, errorMsg);
			});
		}
		return beanValidator;
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//将hibernate 的validator通过工厂的形式实例化
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
		
	}

}
