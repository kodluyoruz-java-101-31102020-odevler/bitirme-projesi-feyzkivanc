package com.spring.library.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.spring.library.app.annotation.RunningTime;



@Aspect
@Component
public class RunningTimeAspect {
	@Around("@annotation(runningTime)")
	public Object execute(ProceedingJoinPoint joinPoint, RunningTime runningTime) 
			throws Throwable {
		
		if(!runningTime.active()) {
			return joinPoint.proceed();
		}
		
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		
		String methodName = joinPoint.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object result = joinPoint.proceed();
		
		stopWatch.stop();
		
		System.out.println(className + "#" + methodName + " runnedin " + stopWatch.getTotalTimeMillis() + " ms");
		
		return result;
	}


}
