package com.pc.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author pc
 * @date 2019/07/09 16:11
 **/
@Configuration
@MapperScan("com.pc.blog.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Bean(name = "dataSource")
    public DruidDataSource createDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

}
