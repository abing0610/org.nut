package org.nut.bean.support;


import org.nut.bean.factory.BeanFactory;
import org.nut.bean.utils.PropertyValue;
import org.nut.bean.utils.PropertyValues;
import org.w3c.dom.stylesheets.LinkStyle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by abing on 2016/1/8.
 */
public class AbstractBeanFactory implements BeanFactory {

    public static Map<String , BeanDefinition> beanMap = new ConcurrentHashMap<String, BeanDefinition>();

    /**
     * 把bean注册到BeanDefinition中
     *
     * 使用法反射 把属性注入进去
     *
     * @param name
     * @param definition
     */
    public void registerBeanDefinition(String name , BeanDefinition definition){
        beanMap.put(name, definition);
        definition.setName(name);

        PropertyValues values = definition.getPropertyValues();
        List<PropertyValue> list = values.getPropertyValue();
        if (list.size() == 0) {
            return;
        }
        Object bean = definition.getBean();
        for (PropertyValue value : list) {
            Object obj = value.getValue();
            if (obj instanceof BeanReference){
                BeanReference beanReference = (BeanReference) obj;
                obj = this.getBean(beanReference.getName());
            }

            try {
                Method method = bean.getClass().getDeclaredMethod("set" + value.getName().substring(0 , 1).toUpperCase()
                        + value.getName().substring(1) , obj.getClass());
                method.setAccessible(true);
                method.invoke(bean , obj);
            } catch (NoSuchMethodException e) {
                try {
                    Field field = bean.getClass().getDeclaredField(value.getName());
                    field.setAccessible(true);
                    field.set(bean , obj);

                } catch (NoSuchFieldException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }

            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取bean
     *
     * @param bean
     * @return
     */
    public Object getBean(String bean) {
        if (beanMap == null){
            return null;
        }else {
            BeanDefinition beans = beanMap.get(bean);
            Object obj = beans.getBean();
            return  obj;
        }
    }
}
