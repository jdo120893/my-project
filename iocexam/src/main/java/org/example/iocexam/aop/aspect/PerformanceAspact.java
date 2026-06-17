package org.example.iocexam.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Aspect
@Component
public class PerformanceAspact {

    @Around("@annotation(org.example.iocexam.aop.annotation.TrackTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint)
        throws Throwable {
        long startTime = System.currentTimeMillis();

        try {

            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();

            System.out.println(String.format(
                    "[Performance %s.%s() executed in %dms",
                    className, methodName, executionTime
            ));
        }
    }
}

