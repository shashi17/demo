package com.infy.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.infy.service.*Impl.*(..))")
	public void before() throws Exception {

		logger.info("Before advice called.");

	}

	@After("execution(* com.infy.service.*Impl.*(..))")
	public void after() throws Exception {
		logger.info("After advice called.");
	}

	@AfterReturning("execution(* com.infy.service.*Impl.*(..))")
	public void afterReturning() throws Exception {
		logger.info("After returning advice called.");

	}

	@AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
	public void afterThrowing(Exception exception) throws Exception {
		logger.error(exception.getMessage(), exception);
	}

	@Around("execution(* com.infy.service.*Impl.*(..))")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.error("Before proceeding part of the Around advice.");
		proceedingJoinPoint.proceed();
		logger.error("After proceeding part of the Around advice.");

	}

}
