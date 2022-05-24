package ml.java.spring5;

import ml.java.spring5.aop0.ActorService;
import ml.java.spring5.aop1.Aop1Config;
import ml.java.spring5.aop1.UserService;
import ml.java.spring5.ioc0.User;
import ml.java.spring5.ioc1.Ioc1Config;
import ml.java.spring5.ioc1.Film;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5ApplicationTests {

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
        Film film = annotationConfigApplicationContext.getBean("film", Film.class);
        film.hello();
        annotationConfigApplicationContext.close();
    }

    @Test
    public void testAop0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop0.xml");
        ActorService actorService = applicationContext.getBean("actorService", ActorService.class);
        actorService.getFilm("Movie 1");
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
    }

}
