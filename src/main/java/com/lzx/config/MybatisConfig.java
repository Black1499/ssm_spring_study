package com.lzx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

@Component
@EnableTransactionManagement
public class MybatisConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Autowired
    private Environment environment;

    @Bean("dataSource")
    public DataSource dataSourceConfig() throws PropertyVetoException {
        // 使用c3p0
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setDriverClass(driver);
        source.setJdbcUrl("jdbc:mariadb://localhost:3306/testdb");
        source.setUser(environment.getProperty("jdbc.user"));
        source.setPassword("123456");
        return source;
    }

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBeanConfig() throws PropertyVetoException, IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(this.dataSourceConfig());
        factoryBean.setTypeAliasesPackage("com.lzx.entity");
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = {
//                new ClassPathResource("mappers/EmployeeMapper.xml")
//        };
        factoryBean.setMapperLocations(resolver.getResources("mappers/*.xml"));
        return factoryBean;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManagerConfig() throws PropertyVetoException {
        return new DataSourceTransactionManager(this.dataSourceConfig());
    }


    // JdbcTemplate
    @Bean
    public JdbcTemplate  jdbcTemplateConfig() throws PropertyVetoException {
        return new JdbcTemplate(dataSourceConfig());
    }
}
