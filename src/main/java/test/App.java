package test;

import org.nut.bean.io.ResourceLoader;
import org.nut.bean.support.AbstractBeanFactory;
import org.nut.bean.support.BeanDefinition;

import org.nut.bean.support.XmlBeanDefinitionReader;
import org.nut.bean.utils.PropertyValue;
import org.nut.bean.utils.PropertyValues;
import test.service.TestService;

import java.util.Map;

/**
 * Created by abing on 2016/1/8.
 */
public class App {
    public static void main(String[] args) {
        testXmlIoc();
    }

    private void testIoc(){
        AbstractBeanFactory beanFactory = new AbstractBeanFactory();
        BeanDefinition definition = new BeanDefinition();
        definition.setBeanClassName("test.service.TestService");

        PropertyValues values = new PropertyValues();
        values.addPropertyValue(new PropertyValue("name" , "inga hello"));
        values.addPropertyValue(new PropertyValue("value" , "spring"));
        definition.setPropertyValues(values);

        beanFactory.registerBeanDefinition("service", definition);

        TestService service =(TestService) beanFactory.getBean("service");
        service.sayHello();
    }

    private static void testXmlIoc() {
        try {
            AbstractBeanFactory beanFactory = new AbstractBeanFactory();

            XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
            xmlBeanDefinitionReader.loadBeanDefintions("tinyioc.xml");
            Map<String , BeanDefinition> map = xmlBeanDefinitionReader.getRegister();

            for (Map.Entry<String , BeanDefinition> me : map.entrySet()){
                beanFactory.registerBeanDefinition(me.getKey() , me.getValue());
            }

            TestService testService = (TestService)beanFactory.getBean("outputService");
            testService.sayHello();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
