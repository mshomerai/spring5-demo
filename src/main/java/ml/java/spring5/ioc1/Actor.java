package ml.java.spring5.ioc1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "actor01") //不写value默认值：Actor->actor。
public class Actor {

    @Value("LSP")
    private String name;

    public String getName() {
        return name;
    }

}
