package ml.java.spring5.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class UserServiceOrder0Proxy {

    @Pointcut(value = "execution(* add(..))")
    public void pointCut(){
    }

    @Before(value = "execution(* ml.java.spring5.aop1.UserService.add(int,int))")
    public void before(){
        System.out.println("before order 0...");
    }

    //最终返回，报错也会执行，但会覆盖afterThrowing？谨慎使用？
    //@Around(value = "execution(* except(..))")
    @After(value = "execution(int ml.java.spring5.aop1..*(int,..))")
    public void after(){
        System.out.println("after...");
    }

    //报错后环绕中断！
    //@Around(value = "execution(* except(..))")
    @Around(value = "execution(* add(int,*))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("around after...");
        return object;
    }

    //返回后立即执行
    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        System.out.println("after returning...");
    }

    @AfterThrowing(value = "execution(* exce*(..))")
    public void afterThrowing(){
        System.out.println("after throwing...");
    }

}
