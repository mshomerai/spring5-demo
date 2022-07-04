package ml.java.spring5;

import ml.java.spring5.aop0.ActorService;
import ml.java.spring5.aop1.Aop1Config;
import ml.java.spring5.aop1.UserService;
import ml.java.spring5.ioc0.User;
import ml.java.spring5.ioc1.Ioc1Config;
import ml.java.spring5.ioc1.Film;
import ml.java.spring5.ioc1.World;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** v2.1.8 */
public class Spring5ApplicationTests {

    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Ioc1Config.class);

    }

    @Test
    public void testIoc0() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc0.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user constructed");
        user.hello();
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void testIoc1() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Ioc1Config.class);
        //获取容器中所有bean
        for(String bean: annotationConfigApplicationContext.getBeanDefinitionNames()){
            System.out.println(bean);
        }
        //@Component类测试
        Film film = annotationConfigApplicationContext.getBean("film", Film.class);
        film.hello();
        //@Bean+proxyBeanMethods测试
        Ioc1Config ioc1Config = annotationConfigApplicationContext.getBean("ioc1Config", Ioc1Config.class);
        User user0 = annotationConfigApplicationContext.getBean("userA", User.class);
        User user1 = ioc1Config.user();
        System.out.println("user0==user1?" + (user0 == user1));
        //@Import类测试
        World world0 = annotationConfigApplicationContext.getBean("ml.java.spring5.ioc1.World", World.class);
        World world1 = annotationConfigApplicationContext.getBean("ml.java.spring5.ioc1.World", World.class);
        System.out.println("world0==world1?" + (world0 == world1));
        annotationConfigApplicationContext.close();
        //@Bean入参@Bean测试
        User user = annotationConfigApplicationContext.getBean("user", User.class);
        user.hello();
    }

    @Test
    public void testAop0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop0.xml");
        ActorService actorService = applicationContext.getBean("actorService", ActorService.class);
        actorService.getFilm("Movie 1");
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void testAop1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Aop1Config.class);
        UserService userService = annotationConfigApplicationContext.getBean("userService", UserService.class);
        System.out.println(userService.add(1, 2));
//        try {
//            userService.except();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        annotationConfigApplicationContext.close();
    }

}
