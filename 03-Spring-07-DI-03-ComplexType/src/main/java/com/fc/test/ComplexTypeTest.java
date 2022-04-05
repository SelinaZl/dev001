package com.fc.test;

import com.fc.entity.ComplexType;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexTypeTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComplexType bean = applicationContext.getBean("complexType", ComplexType.class);

        System.out.println(bean);

    }
}
