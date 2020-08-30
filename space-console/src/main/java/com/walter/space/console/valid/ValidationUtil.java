package com.walter.space.console.valid;


import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author walter
 * @date 2020/8/30 11:53 下午
 */
public class ValidationUtil {
    private static ValidationUtil util;
    private Validator validator;

    public ValidationUtil(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public Validator getValidator(){
        return validator;
    }

    public static ValidationUtil getValidationUtil(){
        if(util == null){
            util = new ValidationUtil();
        }
        return util;

    }

    public static List<CheckErrorResultBean> validate(Object o){
        Set<ConstraintViolation<Object>> set = ValidationUtil.getValidationUtil().getValidator().validate(o);
        List<CheckErrorResultBean> errorList = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        for(ConstraintViolation<Object> cv:set){
            if(errorList == null){
                errorList = new ArrayList<CheckErrorResultBean>();

            }
            String message = MessageResolver.getMessage(request,cv.getMessage());
            errorList.add(new CheckErrorResultBean(cv.getPropertyPath().toString(),message));
        }
        return  errorList;
    }

    public static <T> List<CheckErrorResultBean> validateList(List<T> objList){
        if (null == objList || objList.isEmpty()){
            return null;
        }
        List<CheckErrorResultBean> strList = new ArrayList<>();
        for (Object obj:objList){
            List<CheckErrorResultBean> checkErrorResultBeans = validate(obj);
            if (null != checkErrorResultBeans){
                strList.addAll(validate(obj));
            }
        }
        return strList;
    }

    public static List<CheckErrorResultBean> validate(Object o ,Class<?> ...c){
        Set<ConstraintViolation<Object>> set = ValidationUtil.getValidationUtil().getValidator().validate(o,c);
        List<CheckErrorResultBean> errorList = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        for(ConstraintViolation<Object> cv:set){
            if(errorList == null){
                errorList = new ArrayList<CheckErrorResultBean>();

            }
            String message = MessageResolver.getMessage(request,cv.getMessage());
            errorList.add(new CheckErrorResultBean(cv.getPropertyPath().toString(),message));
        }
        return  errorList;

    }



}
