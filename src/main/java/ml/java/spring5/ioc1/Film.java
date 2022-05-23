package ml.java.spring5.ioc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Film {

    @Autowired
    @Qualifier(value = "actor01") //不写@Qualifier默认加载唯一Actor类。
    //@Resource(name = "actor01") //不写name默认加载唯一Actor类，加name=@Autowired+@Qualifier，不建议使用
    private Actor actor01;

    public void hello(){
        System.out.println(actor01.getName() + " say hello!");
    }

}
