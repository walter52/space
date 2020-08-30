package com.walter.space.console.valid;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author walter
 * @date 2020/8/30 11:42 下午
 */
public class ValidAop {
    public Object aroudExec(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        Valid annotation = method.getAnnotation(Valid.class);
        if(annotation != null){
            List<CheckErrorResultBean> errorList = new ArrayList<>();
            Object[] args = pjp.getArgs();
            Class<?>[] checkToken = annotation.value();
            Class<?>[] group = annotation.group();
            for(Class<?> c : checkToken){
                for(Object obj:args){
                    if(obj == null){
                        continue;
                    }
                    if(c == obj.getClass()){
                        List<CheckErrorResultBean> result = null;
                        if (group.length<1){
                            result = ValidationUtil.validate(obj);
                        }else {
                            result = ValidationUtil.validate(obj,group);
                        }
                        if(result!=null){
                            errorList.addAll(result);
                        }
                    }
                }
            }
            if(errorList.size()>0){
                throw new Exception("100",Joiner.on(",").join(Lists.transform(errorList,
                        new Function<CheckErrorResultBean,String>(){
                            public String apply(CheckErrorResultBean input){
                              return input.getProperty()+input.getMessage();
                            }
                        }

                        )));
            }
        }

    }

    return pjg.proces;
}
