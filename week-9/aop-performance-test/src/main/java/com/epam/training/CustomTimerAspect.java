package com.epam.training;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * Custom aspect for collecting execution time for methods annotated with {@link CustomTimer}.
 */
@Aspect
@Service
public class CustomTimerAspect {

    @Around("@annotation(com.epam.training.CustomTimer)")
    public Object timeAnnotatedMethod(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        StopWatch stopWatch = new StopWatch(pjp.getTarget().toString());
        stopWatch.start();

        Object retVal = pjp.proceed();

        // stop stopwatch
        stopWatch.stop();

        System.out.println("Execution time for " + pjp.getTarget().toString() + ": " + stopWatch.getTotalTimeMillis() + " ms");

        return retVal;
    }

}
