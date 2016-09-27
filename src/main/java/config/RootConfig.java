package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;


import static org.springframework.orm.jpa.vendor.Database.ORACLE;

/**
 * Created by williaz on 9/26/16.
 * BootStrap JPA
 */
@Configuration

public class RootConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
                      DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){

        LocalContainerEntityManagerFactoryBean emfb=new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("domain");
        return emfb;

    }

    @Bean
    public BasicDataSource dataSource(){

        BasicDataSource ds= new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@192.168.56.101:1521:xe");
        ds.setUsername("will");
        ds.setPassword("will123");

        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true); //auto table creation
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect"); //dialect for DB

        return adapter;

    }






}
