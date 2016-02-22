package com.syl.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * AspectJ
 *
 * Created by shenyunlong on 2/22/16.
 */
@Aspect
public class TraceAspect {

    public static final String TAG = "TraceAspect";

    public static final String POINTCUT_METHOD = "execution(@com.syl.aop.annotation.DebugTrace * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {}

    @Around("methodAnnotatedWithDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        DebugTimer timer = new DebugTimer();
        timer.start();
        Object result = joinPoint.proceed();
        timer.stop();

        Log.d(TAG, buildDebugLog(className, methodName, timer.getDuration()));

        return result;
    }

    private String buildDebugLog(String className, String methodName, long duration) {
        StringBuilder builder = new StringBuilder();

        builder.append(className).append("->").append(methodName).append(" ");
        builder.append("[").append(duration).append(" ms").append("]");

        return builder.toString();
    }
}
