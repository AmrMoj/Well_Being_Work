package tn.esprit.wellbeingwork.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author amoujbani on 7/17/2022
 * @project WellBeingWork
 */
@Component
@Aspect
public class PerformanceAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* tn.esprit.wellbeingwork.controller.*.*(..))")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start= System.currentTimeMillis();
        Object object=proceedingJoinPoint.proceed();
        long elapsedTime=System.currentTimeMillis()-start;
        String elapsedTimeMinutes = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(elapsedTime));
        String elaspedTimeSeconds = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(elapsedTime)% 60);
        String timeElapsed = elapsedTimeMinutes+"m : "+elaspedTimeSeconds+"s";

        log.info("Method: "+proceedingJoinPoint.getSignature().getName()+ " took: "+timeElapsed);
        return object;
    }
}