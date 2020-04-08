package org.example.spring.mvc.spring;

import org.example.spring.mvc.bean.TestBean;
import org.example.spring.mvc.jdbc.DatabasePool;
import org.example.spring.mvc.service.JdbcService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

public class TestSpring {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);

        //类路径
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");


        DatabasePool service = context.getBean("dbPool", DatabasePool.class);
        System.out.println(service.toString());

       // JdbcService service = context.getBean("jdbcService",JdbcService.class);
       // service.getById(100L);
    }
}
