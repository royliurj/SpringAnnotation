package com.roy.springannotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile: Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 * 加入了@Profile只有这个环境被激活才能注册到容器中
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
public class ProfileConfig implements EmbeddedValueResolverAware {

    //第一种
    @Value("${db.user}")
    private String user;
    private String password;
    private String driverClass;

    private StringValueResolver valueResolver;

    //第二种
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///test");
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///shop");
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///jpa");
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    //第三种，通过EmbeddedValueResolverAware获取
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        valueResolver = stringValueResolver;
        driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
