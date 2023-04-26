package com.oranges.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.oranges.service","com.oranges.dao"})
@PropertySource({"classpath:jdbc.properties"})
@Import({jdbcConfig.class, mybatisConfig.class})
@EnableTransactionManagement
public class springConfig {
}
