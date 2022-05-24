package ml.java.spring5.aop1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UserServiceOrder1Proxy {

    @Before(value = "execution(* ml.java.spring5.aop1.UserService.add(int,int))")
    public void before(){
        System.out.println("before order 1...");
    }

}
