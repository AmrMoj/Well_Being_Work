package tn.esprit.wellbeingwork.configuration;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author amoujbani on 7/17/2022
 * @project WellBeingWork
 */
    @Component
    @Aspect
    public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
        @Before("execution(* tn.esprit.wellbeingwork.service.*.*(..))")
        public void logBefore(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("Executing method " + name + " : ");
        }

        @After("execution(* tn.esprit.wellbeingwork.service.*.*(..))")
        public void logAfter(JoinPoint point) {
            log.info("The method "+point.getSignature().getName() + " is called ...");
        }

        @AfterReturning(value = "execution(* tn.esprit.wellbeingwork.service.*.*(..))",
                returning = "retVal")
        public void afterReturningAdvice(JoinPoint jp, Object retVal){
            if (retVal!=null)
                log.info("Method : "  + jp.getSignature().getName()+" Returning: " + retVal.getClass().getSimpleName());
        }

//        @Around("execution(* tn.esprit.wellbeingwork.service.*.*(..))")
//        public void logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
//        log.info("Before Method Execution: "+ joinPoint.getSignature().getName());
//        try {
//            joinPoint.proceed();
//        } finally {
//
//        }
//        log.info("After Method Execution: "+ joinPoint.getSignature().getName());
//            }
    }

