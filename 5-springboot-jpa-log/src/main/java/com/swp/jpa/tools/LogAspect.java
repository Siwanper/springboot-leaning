package com.swp.jpa.tools;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-09 4:23 PM
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(public * com.swp.jpa.controller..*.*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        logger.info(
                "URL : " + request.getRequestURI().toString() + ", IP : " +
                        request.getRemoteAddr() + ", CLASS_METHOD : " +
                        joinPoint.getSignature().getDeclaringTypeName() + "." +
                        joinPoint.getSignature().getName() + ", ARGS : " +
                        Arrays.asList(joinPoint.getArgs())
        );

    }

    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void doAfter(Object object){
        logger.info("RESPONSE : " + object);
    }

}
