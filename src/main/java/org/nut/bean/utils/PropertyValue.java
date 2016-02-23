package org.nut.bean.utils;

/**
 * 设定的属性的名称
 *
 * Created by abing on 2016/1/11.
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name , Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
