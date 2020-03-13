package com.example.annotation.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect// 1.表明这是一个切面类
public class MyLogAspect {

    // 2.PointCut 表示这是一个切点，@annotation 表示这个切点切到一个注解上，后面带该注解的全类名
    // 切面最主要的就是切点，所有的故事都围绕切点发生
    // logPointCut() 代表切点名称
    @Pointcut("@annotation(com.example.annotation.aop.MyLog)")
    public void logPointCut() {
    }

    // 3. 环绕通知
    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint pjp) {

        Object object = null;
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        StringBuffer sb = new StringBuffer();
        for (Object arg : args) {
            sb.append(arg + "、");
        }
        System.out.println(String.format("进入 %S 方法，参数为：%S", methodName, sb.toString()));

        try {
            object = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(String.format("%S 方法执行结束", methodName));
        return object;
    }
}




