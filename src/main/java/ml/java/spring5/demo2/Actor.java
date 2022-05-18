package ml.java.spring5.demo2;

import org.springframework.stereotype.Component;

@Component(value = "actor") //不写value默认值：Actor->actor。
public class Actor {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
