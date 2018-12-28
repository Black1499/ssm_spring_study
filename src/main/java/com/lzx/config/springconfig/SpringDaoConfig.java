package com.lzx.config.springconfig;

import com.lzx.config.MybatisConfig;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.beans.PropertyVetoException;


@Configuration
@ComponentScan(basePackages = "com.lzx.dao") // 扫描包
@PropertySource("classpath:jdbc.properties") // 读取properties配置文件
@Import(MybatisConfig.class) // 导入MyBatis的配置
public class SpringDaoConfig  {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurerConfig() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setBasePackage("com.lzx.dao");
        return configurer;
    }
}
