package ml.java.spring5.ioc1;

import ml.java.spring5.ioc0.City;
import ml.java.spring5.ioc0.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration //默认proxyBeanMethods = true
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = {"ml.java.spring5.ioc1"})
@Import({World.class}) //getBean时名称为全路径类名：ml.java.spring5.ioc1.World
public class Ioc1Config {

    //@Bean：创建单实例Bean。使用context.getBean()获取。不受proxyBeanMethods影响？
    //proxyBeanMethods=true时，调用ioc1Config.user()也是单实例。
    //proxyBeanMethods=false时，调用ioc1Config.user()不是单实例。不做单例检查，创建速度快。
    @Bean("userA") //bean名称userA
    public User user(){
        User user = new User();
        user.setName("a");
        user.setCity(cityA()); //cityA()根据proxyBeanMethods决定是否单实例
        return user;
    }

    @Bean //bean名称默认cityA
    public City cityA(){
        City city = new City();
        city.setRegion("SH");
        return city;
    }

}
