package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;
import sample.bean.MyBean;

public class MyBeanConfig {
//    스프링 공장에게 나 어떤 빈을 관리할지 알려주는 파일.
//    xml
//    <bean id="myBean" class="sample.bean.Mybean"></bean>
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean myBean3() {
        return new MyBean();
    }


    @Bean
    public Book book(){
        return new Book();
    }
}
