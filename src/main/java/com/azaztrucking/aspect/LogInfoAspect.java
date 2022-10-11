package com.azaztrucking.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.azaztrucking.doa.LogInfoDAO;
import com.azaztrucking.model.LogInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
@ToString
@Getter 
@Setter
public class LogInfoAspect {
	
	private final LogInfoDAO logInfoDAO;
	private final ObjectMapper objectMapper;

//	@Pointcut(value="execution(* com.azaztrucking.controller.AzazTruckingController.addDriver(..) )")
//	public void myPointcut() {
//		
//	}

	@Pointcut("@annotation(com.azaztrucking.aspect.AzazTruckingLog)")
	public void logAzazTrucking() {
		
	}
	
	@Around(value = "logAzazTrucking()")
	public Object  applicationlogInfo(ProceedingJoinPoint pjp) throws Throwable {
		
		
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		LogInfo logInfoReq = new LogInfo();
		logInfoReq.setClass_name(className);
		logInfoReq.setFunction_name(methodName);
		logInfoReq.setRequest(objectMapper.writeValueAsString(array[0]));
		logInfoDAO.save(logInfoReq);
		
		Object object = pjp.proceed();
		LogInfo logInfoRes = new LogInfo();
		
		logInfoRes.setClass_name(className);
		logInfoRes.setFunction_name(methodName);
		logInfoRes.setResponse(objectMapper.writeValueAsString(object));
		logInfoDAO.save(logInfoRes);
		
		return object;
		
	}
}
