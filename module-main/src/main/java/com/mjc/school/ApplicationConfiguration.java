

package com.mjc.school;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import com.mjc.school.util.ConfigurationUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import javax.persistence.EntityManager;
//import java.lang.reflect.Proxy;
//
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.mjc.school.*")
@ConfigurationPropertiesScan
public class ApplicationConfiguration {
}
//    @Bean
//    public static SessionFactory buildSessionFactory() {
//        org.hibernate.cfg.Configuration configuration = ConfigurationUtil.buildConfiguration();
//        configuration.configure();
//        return configuration.buildSessionFactory();
//    }
//
//    @Bean
//    public EntityManager entityManager() {
//        var sessionFactory = buildSessionFactory();
//        return (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
//                (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));
//    }
////    @Bean
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource());
////        sessionFactory.setPackagesToScan("com.mjc.school.repository");
//////        sessionFactory.setAnnotatedClasses(User.class);
////        sessionFactory.setHibernateProperties(hibernateProperties());
////
////        return sessionFactory;
////    }
////    @Bean
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("org.postgresql.Driver");
////        dataSource.setUrl("jdbc:postgresql://localhost:5432/epam_news");
////        dataSource.setUsername("epam_news");
////        dataSource.setPassword("password");
////
////        return dataSource;
////    }
////
////
////    private Properties hibernateProperties() {
////        Properties properties = new Properties();
////        properties.setProperty("hibernate.connection.pool_size", "3");
////        properties.setProperty("hibernate.current_session_context_class", "thread");
////        properties.setProperty("hibernate.hbm2ddl.auto", "update");
////        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
////        properties.setProperty("hibernate.show_sql", "true");
////
////        return properties;
////    }
////
////    @Bean
////    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
////        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
////        transactionManager.setSessionFactory(sessionFactory);
////        return transactionManager;
////    }
//}
