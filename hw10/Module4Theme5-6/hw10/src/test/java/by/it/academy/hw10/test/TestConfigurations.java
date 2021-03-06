package by.it.academy.hw10.test;


import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@PropertySource(value = "classpath:testdatasource.properties")
@ComponentScan(basePackages = "by.it.academy.hw10")
@EnableTransactionManagement
@Configuration
public class TestConfigurations {


        @Autowired
        Environment environment;

        @Bean
        public DataSource dataSource() {

            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(environment.getProperty("datasource.url"));
            dataSource.setDriverClassName(Driver.class.getName());
            dataSource.setUsername(environment.getProperty("datasource.username"));
            dataSource.setPassword(environment.getProperty("datasource.password"));
            dataSource.setInitialSize(20);
            dataSource.setMaxTotal(30);
            return dataSource;

        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSource());
            em.setPackagesToScan("by.it.academy.hw10");
            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);
            em.setJpaProperties(additionalProperties());

            return em;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
            return new PersistenceExceptionTranslationPostProcessor();
        }

        Properties additionalProperties() {
            Properties properties = new Properties();
            properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
            properties.setProperty("hibernate.show_sql","true");
            properties.setProperty("hibernate.format_sql","true");
            properties.setProperty("hibernate.enable_lazy_load_no_trans","true");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

            return properties;
        }
    }
