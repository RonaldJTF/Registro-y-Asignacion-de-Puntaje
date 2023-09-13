package co.edu.unipamplona.ciadti.rap.services.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( entityManagerFactoryRef = "generalEntityManagerFactory",
                        transactionManagerRef = "generalTransactionalManager",
                        repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,
                        basePackages = {"co.edu.unipamplona.ciadti.rap.services.model.general.dao"})
public class GeneralConfig {
    @Autowired
    private Environment env;

    @Bean(name = "generalDataSource")
    public DataSource generalDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("general.datasource.url"));
        dataSource.setUsername(env.getProperty("general.datasource.username"));
        dataSource.setPassword(env.getProperty("general.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("general.datasource.driver-class-name"));
        return dataSource;
    }

    @Bean(name = "generalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(generalDatasource());
        em.setPackagesToScan("co.edu.unipamplona.ciadti.rap.services.model.general.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("general.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("general.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("general.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "generalTransactionalManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

