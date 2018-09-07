package com.roy.springannotation.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务
 * 1,导入相关依赖
 * 2，配置数据源、jdbcTemplate操作数据
 * 3,开启基于注解的事务管理功能 @EnableTransactionManagement
 * 4，配置事务管理器
 */
@EnableTransactionManagement
@ComponentScan("com.roy.springannotation.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    //配置JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //配置事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
