//package com.azaztrucking.aspect;
//
//import java.util.Arrays;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import com.azaztrucking.doa.LogInfoDAO;
//import com.azaztrucking.model.LogInfo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//
//@Aspect
//@Component
//@Slf4j
//@RequiredArgsConstructor
//@ToString
//@Getter 
//@Setter
//public class LoggingAspect {
//	
//	private final LogInfoDAO logInfoDAO;
//
//	@Pointcut(value="execution(* com.azaztrucking.*.*.*(..) )")
//	public void myPointcut() {
//		
//	}
//	
//	@Around("myPointcut()")
//	public Object  applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String methodName = pjp.getSignature().getName();
//		String className = pjp.getTarget().getClass().toString();
//		Object[] array = pjp.getArgs();
//		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
//				+ mapper.writeValueAsString(array[0]));
//		Object object = pjp.proceed();
//		log.info(className + " : " + methodName + "()" + "Response : "
//				+ mapper.writeValueAsString(object));
//		return object;
//		
//	}
//	
//	
//}
