package ml.java.spring5.aop0;

public class ActorService {

    public String getFilm(String name){
        System.out.println("get film...");
        return name + " film list";
    }

}
