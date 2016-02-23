package org.nut.bean.support;

/**
 * Created by abing on 2016/1/15.
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
