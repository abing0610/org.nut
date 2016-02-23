package org.nut.bean.support;

import org.nut.bean.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abing on 2016/1/14.
 */
public abstract class  AbstractBeanDefitionReader implements BeanDefinitionReader {

    private Map<String , BeanDefinition> register;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefitionReader(ResourceLoader resourceLoader){
        this.register = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String , BeanDefinition> getRegister(){
        return register;
    }

    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }

}
