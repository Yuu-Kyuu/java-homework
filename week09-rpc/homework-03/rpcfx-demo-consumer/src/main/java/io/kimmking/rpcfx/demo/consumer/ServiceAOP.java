package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.api.RpcfxException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ServiceAOP {
    @Around("execution( * io.kimmking.rpcfx.demo.api.UserService.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        // 获取当前方法对象
        Method method = methodSignature.getMethod();
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //TODO 没想好怎么处理
            if (throwable.getMessage().equals(RpcfxException.RPCFX_EXCEPTION)) {
                obj = throwable;
            }
        }
        return obj;
    }
}
