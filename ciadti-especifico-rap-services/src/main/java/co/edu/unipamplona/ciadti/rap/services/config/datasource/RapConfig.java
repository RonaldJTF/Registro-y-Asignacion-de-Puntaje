package co.edu.unipamplona.ciadti.rap.services.config.datasource;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories( entityManagerFactoryRef = "rapEntityManagerFactory",
                        transactionManagerRef = "rapTransactionalManager",
                        repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,
                        basePackages = {"co.edu.unipamplona.ciadti.rap.services.model.rap.dao"})
public class RapConfig {

    private final Environment env;

    @Bean(name = "rapDataSource")
    public DataSource generalDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("rap.datasource.url"));
        dataSource.setUsername(env.getProperty("rap.datasource.username"));
        dataSource.setPassword(env.getProperty("rap.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("rap.datasource.driver-class-name"));
        return dataSource;
    }

    @Bean(name = "rapEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(generalDatasource());
        em.setPackagesToScan("co.edu.unipamplona.ciadti.rap.services.model.rap.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("rap.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("rap.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("rap.jpa.database-platform"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "rapTransactionalManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

