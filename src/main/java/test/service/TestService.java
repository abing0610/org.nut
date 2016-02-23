package test.service;

/**
 * Created by abing on 2016/1/8.
 */
public class TestService {

    private String name;

    private String value;

    private Work work;

    public void sayHello() {
        System.out.println("this is hello!");
        System.out.println(name + "  :  " + value);
        work.sayWork();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
