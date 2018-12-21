package com.lzx.spring.aop;

import com.lzx.spring.aop.demo.AopTestAspect;
import com.lzx.spring.aop.demo.JdbcAspect;
import com.lzx.spring.aop.jdbc.QueryAspect;
import com.lzx.spring.aop.jdbc.UpdateAspect;
import org.springframework.context.annotation.Bean;

// @Configuration
//@EnableAspectJAutoProxy
// @ComponentScan("com.lzx.spring.aop")
public class AopConfig {

    @Bean
    public AopTestAspect getPrint(){
        return new AopTestAspect();
    }

    @Bean
    public JdbcAspect getJdbcAspect(){
        return new JdbcAspect();
    }

    @Bean
    public QueryAspect getQueryAspect(){
        return new QueryAspect();
    }

    @Bean
    public UpdateAspect getUpdateAspect(){
        return new UpdateAspect();
    }


}
