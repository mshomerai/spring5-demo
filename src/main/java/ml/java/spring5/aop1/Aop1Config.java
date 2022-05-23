package ml.java.spring5.aop1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"ml.java.spring5.aop1"})
@EnableAspectJAutoProxy
public class Aop1Config {
}
