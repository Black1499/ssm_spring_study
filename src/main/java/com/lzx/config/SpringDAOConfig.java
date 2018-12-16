package com.lzx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

// @ComponentScan(basePackages ="com.lzx.dao")
// 注解装配该包下的所有bean

@Configuration
@PropertySource("classpath:jdbc.properties")
public class SpringDAOConfig implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean("dataSource")
    public DataSource dataSourceConfig() throws PropertyVetoException {
//        使用 commons-pool
//        Properties properties = new Properties();
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        properties.setProperty("driver", "org.mariadb.jdbc.Driver");
//        properties.setProperty("url", "jdbc:maraidb://localhost:3306/testdb");
//        properties.setProperty("driver", "root");
//        properties.setProperty("driver", "123456");
//        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        // 使用c3p0
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass("org.mariadb.jdbc.Driver");
        source.setJdbcUrl("jdbc:mariadb://localhost:3306/testdb");
        source.setUser("root");
        source.setPassword("123456");

        System.out.println(environment.getProperty("jdbc.user"));
        System.out.println("${jdbc.driver}");
        return source;
    }

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBeanConfig() throws PropertyVetoException {
        //Resource resource = new ClassPathResource();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(this.dataSourceConfig());
        factoryBean.setTypeAliasesPackage("com.lzx.entity");
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        Resource[] resources = {
                new ClassPathResource("mappers/EmployeeMapper.xml")
        };

        factoryBean.setMapperLocations(resources);
        return factoryBean;
    }

    @Bean("mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurerConfig() throws PropertyVetoException {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setBasePackage("com.lzx.dao");
        return configurer;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManagerConfig() throws PropertyVetoException {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(this.dataSourceConfig());
        return manager;
    }

    @Bean
    public BeanDefinitionBuilder setProxyTargetClass() {
        return null;
    }


}
