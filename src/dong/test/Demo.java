package dong.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/10/25.
 */
public class Demo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Person p = new Person();

        for (int i = 0;i < 5;i++) {
            p.setCode(""+i);
        }

        list.add(p);

        for (Person person:list) {
            System.out.println(person.getCode());
        }

        System.out.println(list);
    }
}
class Person {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
