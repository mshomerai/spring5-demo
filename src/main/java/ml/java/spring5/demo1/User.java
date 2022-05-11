package ml.java.spring5.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private String name;
    private City city;
    private int[] array;
    private List<String> list;
    private Map<Integer,String> map;
    private Set<String> set;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }

    public void hello(){
        System.out.println("hello " + name + " in " + city.getRegion());
        System.out.println("array " + Arrays.toString(array));
        System.out.println("list " + list.toString());
    }

}
