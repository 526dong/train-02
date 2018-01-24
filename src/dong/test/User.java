package dong.test;

import java.math.BigDecimal;

/**
 * @author Created by xzd on 2017/11/9.
 */
public class User {
    private String id;

    private String age;

    private String name;

    private Integer degree;

    public User() {}

    public User(String id, String age, String name, Integer degree) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.degree = degree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
