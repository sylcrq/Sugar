package com.syl.aop;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import com.syl.aop.utils.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * AspectJ
 *
 * Created by shenyunlong on 2/22/16.
 */
@Aspect
public class TraceAspect {

    public static final String POINTCUT_METHOD_DEBUG_TRACE = "execution(@com.syl.aop.annotation.DebugTrace * *(..))";
    public static final String POINTCUT_CONSTRUCTOR_DEBUG_TRACE = "execution(@com.syl.aop.annotation.DebugTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD_DEBUG_TRACE)
    public void methodWithDebugTrace() {}

    @Pointcut(POINTCUT_CONSTRUCTOR_DEBUG_TRACE)
    public void constructorWithDebugTrace() {}

    @Around("methodWithDebugTrace() || constructorWithDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        enterMethod(joinPoint);

        StopWatch timer = new StopWatch();
        timer.start();
        Object result = joinPoint.proceed();
        timer.stop();
        timer.getElapsedTime();

        exitMethod(joinPoint, result, timer.getElapsedTime());

        return result;
    }

    /**
     * 进入函数时:
     * 1. 打印调试Log(类名, 方法名, 传入的参数, 当前的线程名/ID)
     * 2. 开始Systrace
     *
     * @param joinPoint
     */
    private void enterMethod(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        Class<?> clazz =  codeSignature.getDeclaringType();
        String methodName = codeSignature.getName();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();

        StringBuilder builder = new StringBuilder("====> ");
        builder.append("Thread [").append(Thread.currentThread().getName()).append("/").append(Thread.currentThread().getId()).append("] # ");
        builder.append(methodName).append(" (");
        for (int i=0; i<parameterValues.length; i++) {
            builder.append(parameterNames[i]).append("=").append(parameterValues[i]).append(", ");
        }
        builder.append(")");

        String tag = clazz.getSimpleName();
        Log.d(tag, builder.toString());

        // Start Systrace
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Trace.beginSection(tag);
        }
    }

    /**
     * 退出函数前:
     * 1. 打印调试Log(类名, 方法名, 返回值, 当前的线程名/ID)
     * 2. 结束Systrace
     *
     * @param joinPoint
     * @param result
     * @param elapsedTime
     */
    private void exitMethod(ProceedingJoinPoint joinPoint, Object result, long elapsedTime) {
        // Stop Systrace
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Trace.endSection();
        }

        Signature signature = joinPoint.getSignature();

        Class<?> clazz = signature.getDeclaringType();
        String methodName = signature.getName();
        boolean hasReturnType = (signature instanceof MethodSignature) &&
                ((MethodSignature) signature).getReturnType() != void.class;

        StringBuilder builder = new StringBuilder("====> ");
        builder.append("Thread [").append(Thread.currentThread().getName()).append("/").append(Thread.currentThread().getId()).append("] # ");
        builder.append(methodName).append(" [");
        builder.append(elapsedTime).append("ms] ");

        if(hasReturnType) {
            builder.append("Return=").append(result);
        }

        String tag = clazz.getSimpleName();
        Log.d(tag, builder.toString());
    }
}
