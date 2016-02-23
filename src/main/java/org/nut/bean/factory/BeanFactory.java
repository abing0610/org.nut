package org.nut.bean.factory;

import org.nut.bean.support.BeanDefinition;

/**
 * Created by abing on 2016/1/8.
 */
public interface BeanFactory {
    Object getBean(String bean);
    void registerBeanDefinition(String name , BeanDefinition definition);
}
