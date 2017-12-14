package com.alkfejl.recipeapp.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.alkfejl.recipeapp.repository")
@PropertySource("classpath:/application.properties")
public class DataBaseConfiguration {

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfb.setPackagesToScan("com.alkfejl.recipeapp.model");
        emfb.setJpaProperties(hibernateProps());
        emfb.setDataSource(dbProps());
        emfb.afterPropertiesSet();

        return emfb.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpa = new JpaTransactionManager();
        jpa.setEntityManagerFactory(entityManagerFactory());
        return jpa;
    }

    @Bean
    public Properties hibernateProps() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", hibernateDialect);
        props.setProperty("hibernate.show_sql", hibernateShowSql);
        props.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        return props;
    }

    @Bean
    public DataSource dbProps() {
        BasicDataSource props = new BasicDataSource();
        props.setDriverClassName(dbDriver);
        props.setUrl(dbUrl);
        props.setUsername(dbUsername);
        props.setPassword(dbPassword);
        props.setConnectionProperties("useUnicode=yes; characterEncoding=UTF8");
        return props;
    }
}
