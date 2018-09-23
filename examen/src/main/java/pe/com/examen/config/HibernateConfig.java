package pe.com.examen.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"pe.com.examen.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DIALECT="org.hibernate.dialect.Oracle10gDialect";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="bd_venta";
	private static final String PASSWORD="123";
	
	@Bean 
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("pe.com.examen.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
