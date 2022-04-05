package com.fc.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

//用来导入配置文件
@PropertySource("classpath:jdbc.properties")

//声明了此注解，说明了当前类是一个配置类，替换掉配置文件
@Configuration

//扫描当前类下的所有注解
@ComponentScan("com.fc")
public class ApplicationContextConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //@Bean注解用来将当前方法的返回值放到容器中
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = null;

        try {
            Properties properties = new Properties();

            properties.setProperty("driverClassName", driverClassName);
            properties.setProperty("url", url);
            properties.setProperty("username", username);
            properties.setProperty("password", password);

            DataSource dataSource;

            dataSource = DruidDataSourceFactory.createDataSource(properties);

            jdbcTemplate= new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jdbcTemplate;
    }










}
