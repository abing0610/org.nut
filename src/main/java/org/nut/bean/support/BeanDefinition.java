package org.nut.bean.support;

import org.nut.bean.utils.PropertyValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abing on 2016/1/8.
 */
public class BeanDefinition {

    //�����Զ����bean������
    private String name;

    //�����bean��ʵ��ȫ������
    private String beanClassName;

    //�����bean Object����
    private Object bean;

    //��ŵ�����ֵ
    private PropertyValues propertyValues;

//    public BeanDefinition(Object obj){
//        if (serviceList == null) {
//            serviceList = new ArrayList<Object>();
//        }
//        serviceList.add(obj);
//
//    }


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        try {
            this.beanClassName = beanClassName;
            if(beanClassName != null) {
                bean = Class.forName(beanClassName).newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        if (propertyValues == null){
            propertyValues = new PropertyValues();
        }
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;

    }
}
