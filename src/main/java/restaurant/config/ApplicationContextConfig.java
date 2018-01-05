/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.config;

import restaurant.dao.DishDAO;
import restaurant.dao.OrderDAO;
import restaurant.dao.impl.DishDAOImpl;
import restaurant.dao.impl.OrderDAOImpl;
import java.util.Properties;
 
import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import restaurant.dao.BranchDAO;
import restaurant.dao.HistoryDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.dao.impl.BranchDAOImpl;
import restaurant.dao.impl.HistoryDAOImpl;
import restaurant.dao.impl.OrderDetailDAOImpl;
 
@Configuration
@ComponentScan("restaurant.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {
 
  
 
   // Lưu trữ các giá thuộc tính load bởi @PropertySource.
   @Autowired
   private Environment env;
 
   @Bean
   public ResourceBundleMessageSource messageSource() {
       ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
       // Load property in message/validator.properties
       rb.setBasenames(new String[] { "messages/validator" });
       return rb;
   }
 
   @Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/jsp/");
       viewResolver.setSuffix(".jsp");
       return viewResolver;
   }
    
 
   @Bean(name = "dataSource")
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
  
       // Xem: ds-hibernate-cfg.properties
       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
       dataSource.setUrl(env.getProperty("ds.url"));
       dataSource.setUsername(env.getProperty("ds.username"));
       dataSource.setPassword(env.getProperty("ds.password"));
        
       System.out.println("## getDataSource: " + dataSource);
        
       return dataSource;
   }
 
   @Autowired
   @Bean(name = "sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
       Properties properties = new Properties();
 
  
       // Xem: ds-hibernate-cfg.properties
       properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
       properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
        
 
       LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
  
       // Package chứa các entity class.
       factoryBean.setPackagesToScan(new String[] { "restaurant.entity" });
       factoryBean.setDataSource(dataSource);
       factoryBean.setHibernateProperties(properties);
       factoryBean.afterPropertiesSet();
       //
       SessionFactory sf = factoryBean.getObject();
       System.out.println("## getSessionFactory: " + sf);
       return sf;
   }
 
   @Autowired
   @Bean(name = "transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
       return transactionManager;
   }
 
 
 
   @Bean(name = "dishDAO")
   public DishDAO getDishDAO() {
       return new DishDAOImpl();
   }
 
   @Bean(name = "orderDAO")
   public OrderDAO getOrderDAO() {
       return new OrderDAOImpl();
   }
    @Bean(name = "branchDAO")
   public BranchDAO getBranchDAO() {
       return new BranchDAOImpl();
   }
    @Bean(name = "orderDetailDAO")
   public OrderDetailDAO getOrderDetailDAO() {
       return new OrderDetailDAOImpl();
   }
   @Bean(name = "historyDAO")
   public HistoryDAO getHistoryDAO() {
       return new HistoryDAOImpl();
   }
}
