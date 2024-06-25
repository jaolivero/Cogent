package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDemo {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml");

       ProductService service = context.getBean("productService", ProductService.class);

        System.out.println(service.multiply(100,10));

    }
}
