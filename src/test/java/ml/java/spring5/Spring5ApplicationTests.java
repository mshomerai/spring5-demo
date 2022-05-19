package ml.java.spring5;

import ml.java.spring5.demo1.User;
import ml.java.spring5.demo2.Actor;
import ml.java.spring5.demo2.Film;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5ApplicationTests {

    @Test
    public void test1() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user constructed");
        user.hello();
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Film film = applicationContext.getBean("film", Film.class);
        film.hello();
    }

}
