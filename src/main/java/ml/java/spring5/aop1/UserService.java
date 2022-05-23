package ml.java.spring5.aop1;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public int add(int a,int b){
        System.out.println("adding...");
        return a+b;
    }

    public void except() throws Exception {
        System.out.println("excepting...");
        throw new Exception("userService exception...");
    }

}
