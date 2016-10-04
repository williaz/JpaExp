package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import static org.springframework.orm.jpa.vendor.Database.ORACLE;

/**
 * Created by williaz on 9/26/16.
 * BootStrap JPA
 */
@Configuration
@EnableJpaRepositories(basePackages = {"dao","exp"})
@ComponentScan
@EnableTransactionManagement
public class RootConfig {


    @Bean
    public BasicDataSource dataSource(){

        BasicDataSource ds= new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@192.168.56.101:1521:xe");
        ds.setUsername("will");
        ds.setPassword("will123");

        return ds;
    }
    /*
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true); //auto table creation
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect"); //dialect for DB

        return adapter;

    }
    */
// return type is EntityManagerFactory, not LocalContainerEntityManagerFactoryBean
    @Bean
    public EntityManagerFactory entityManagerFactory(){

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true); //auto table creation
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect"); //dialect for DB
//
        LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan(new String[]{"domain","exp"});
        factory.afterPropertiesSet();//must have to successfully create factory!!!!

        return factory.getObject();

    }

    @Bean
    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager tm= new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory());
        return tm;

    }


    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }





}
