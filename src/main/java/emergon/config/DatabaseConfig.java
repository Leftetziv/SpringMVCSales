/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Leyteris
 * arxeio config gia na syndeso to project me tin vasi me hibarnate
 * 
 */
@Configuration
@EnableTransactionManagement //inform spring container to take into account annotations about transactions about @Transactional
public class DatabaseConfig {
    
    //datasource, tha to xrisimopoieiso sto session factory
    public DataSource datasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/sales?serverTimezone=Europe/Athens");
        datasource.setUsername("root");
        datasource.setPassword("1234");
        
        return datasource;
    }
    
    
    //hibarnate properties, tha to xrisimopoieiso sto session factory
    private Properties hibernateProperties() {
        //properties object is something like a hash map
        Properties properties = new Properties();
        
        //to hibarnate den asxoleite me poia vasi vriskete apo kato genika, alla me to dialect ton voithame 
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        
        properties.put("hibernate.hbm2ddl.auto", "none"); //table generation strategy
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        
        
        return properties;
    }
    
    //session factory
    @Bean(name = "sessionFactory") //to exo kanei bean, gia na mporo na to kano eukola inject apo ta dao
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        
        sessionFactory.setDataSource(datasource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("emergon.entity");
        
        return sessionFactory;
    }
    
    //method to take care of transactions
    @Bean //to kanei bean, gia na mpei sto Spring Container
    @Autowired //gia na kanei inject to SessionFactory s apo tin proigoumeni methodo pou tin exo kanei bean
    public HibernateTransactionManager transactionManager(SessionFactory s) { //
        
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        
        transactionManager.setSessionFactory(s);
        
        return transactionManager;
    }
    
    
}
