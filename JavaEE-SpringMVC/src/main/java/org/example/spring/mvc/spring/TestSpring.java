package org.example.spring.mvc.spring;

import org.example.spring.mvc.aspect.TestAspect;
import org.example.spring.mvc.service.JdbcService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author DELL
 */
@ComponentScan("org.example.spring.mvc.*")
@EnableAspectJAutoProxy

public class TestSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestSpring.class);

        TestAspect testAspect = context.getBean("testAspect", TestAspect.class);
        System.out.println(testAspect.toString());

        JdbcService jdbcService = context.getBean("jdbcService",JdbcService.class);
        jdbcService.getJdbcService();

        //类路径
//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
//
//
//        DatabasePool service = context.getBean("dbPool", DatabasePool.class);
//        System.out.println(service.toString());

       // JdbcService service = context.getBean("jdbcService",JdbcService.class);
       // service.getById(100L);


    }
}
