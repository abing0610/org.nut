package org.nut.bean.support;


import org.nut.bean.io.ResourceLoader;
import org.nut.bean.utils.PropertyValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 具体解析xml节点的类
 *
 * Created by abing on 2016/1/14.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefitionReader {
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    /**
     * 获取xml的路径信息 并解析成InputStream流
     *
     * 转换为InputStream以后。 放入beanDefinition中
     *
     *
     * @param location
     * @throws Exception
     */
    public void loadBeanDefintions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        registerBeanDefinition(inputStream);
    }

    /**
     * 使用DOM进行xml的解析
     *
     * 解析完成以后放入BeanDefinition中
     *
     * @param inputStream
     */
    protected void registerBeanDefinition(InputStream inputStream){
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            Element rootElements = document.getDocumentElement();

            parseBeanDefnition(rootElements);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }  catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析xml的节点
     *
     * @param root
     */
    protected void parseBeanDefnition(Element root){
        NodeList list = root.getChildNodes();
        if (list != null){
            for (int i = 0 ; i < list.getLength() ; i ++){
                Node node = list.item(i);
                if (node instanceof Element){
                    Element ele = (Element) node;
                    processBeanDefinition(ele);
                }
            }
        }
    }

    /**
     * 具体的操作xml 节点 把id和class解析
     *
     * 放入BeanDefinition中的map中
     *
     * @param element
     */
    protected void processBeanDefinition(Element element){
        String id = element.getAttribute("id");
        String beanClass  = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processPRopertyValue(element, beanDefinition);
        beanDefinition.setBeanClassName(beanClass);
        getRegister().put(id , beanDefinition);
    }

    /**
     * 解析节点中的property节点进行解析
     *
     * 把赋值的节点放入property文件中   并解析ref节点 放入BeanReference中
     *
     * @param element
     * @param beanDefinition
     */
    private void processPRopertyValue(Element element , BeanDefinition beanDefinition){
        NodeList list = element.getElementsByTagName("property");
        for (int i = 0 ; i < list.getLength() ; i++){
            Node node = list.item(i);
            if (node instanceof  Element){
                Element proEle = (Element) node;
                String name = proEle.getAttribute("name");
                String value = proEle.getAttribute("value");
                System.out.println(name + " : " + value);
                if (value != null && value.length() > 0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name , value));
                }else {
                    String ref = proEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0){
                        throw new IllegalArgumentException("Congiuration problem : <property> element for property '"
                                + name + "' must specify a ref of value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name , beanReference));

                }
            }
        }
    }


}
