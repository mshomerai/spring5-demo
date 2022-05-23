package ml.java.spring5.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceProxy {

    @Before(value = "execution(* ml.java.spring5.aop1.UserService.add(int,int))")
    public void before(){
        System.out.println("before...");
    }

    //最终返回，无论是否报错都执行？
    @After(value = "execution(int ml.java.spring5.aop1..*(int,..))")
    public void after(){
        System.out.println("after...");
    }

    @Around(value = "execution(* add(int,*))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("around after...");
        return object;
    }

    //返回后立即执行
    @AfterReturning(value = "execution(* add(..))")
    public void afterReturning(){
        System.out.println("after returning...");
    }

    @AfterThrowing(value = "execution(* exce*(..))")
    public void afterThrowing(){
        System.out.println("after throwing...");
    }

}
