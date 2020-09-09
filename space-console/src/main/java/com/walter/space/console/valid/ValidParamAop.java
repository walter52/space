package com.walter.space.console.valid;

import com.walter.space.console.web.exception.ParamsException;
import com.walter.space.console.web.result.RespCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author walter
 * @date 2020/9/9 11:15 下午
 */
@Slf4j
@Aspect
@Component
public class ValidParamAop {

    @Pointcut("@annotation(com.walter.space.console.valid.ValidParam)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        ValidParam ann = method.getAnnotation(ValidParam.class);
        if (ann == null) {
            return pjp.proceed();
        }

        Class<?>[] values = ann.value();
        Class<?>[] group = ann.group();
        Object[] args = pjp.getArgs();

        for (Class<?> val : values) {
            for (Object arg : args) {
                if (arg == null || arg.getClass() != val) {
                    continue;
                }
                toVaild(arg,group);
            }
        }
        return pjp.proceed();
    }

    /**
     * 效验参数
     *
     * @param obj   效验参数对象
     * @param group 分组
     */
    private void toVaild(Object obj, Class<?>[] group) {
        Set<ConstraintViolation<Object>> set;
        if (group == null || group.length == 0) {
            set = Validation.buildDefaultValidatorFactory().getValidator().validate(obj);
        } else {
            set = Validation.buildDefaultValidatorFactory().getValidator().validate(obj, group);
        }

        String msg = set.stream().map(ConstraintViolation::getMessage).reduce((m1, m2) -> m1 + ";" + m2).orElse(RespCode.INVALID_PARAM.getMsg());
        throw new ParamsException(msg);

    }
}
