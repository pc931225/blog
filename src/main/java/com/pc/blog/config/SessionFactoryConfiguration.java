package com.pc.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author pc
 * @date 2019/07/09 16:38
 **/
@Configuration
public class SessionFactoryConfiguration {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
}
