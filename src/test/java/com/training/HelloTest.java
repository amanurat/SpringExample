package com.training;

import com.training.spring.bean.Hello;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Unit test for simple App.
 */
public class HelloTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");

    @Test
    public void testBeanFactory() throws Exception {
        Resource resource = new FileSystemResource("D:\\work-training\\SpringTraining\\src\\main\\resources\\beans.xml");
        BeanFactory factory1 = new XmlBeanFactory(resource);

        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        BeanFactory factory2 = new XmlBeanFactory(resource);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
        BeanFactory factory3 = applicationContext;


        System.out.println("factory1 : "+ factory1);
        System.out.println("factory2 : "+ factory2);
        System.out.println("factory3 : "+ factory3);

    }

    @Test
    public void testLoadFromXmlBean() throws Exception {
        Hello hello = (Hello) context.getBean("hello");
        System.out.println("Hello message : "+ hello.getMessage());

    }


}
