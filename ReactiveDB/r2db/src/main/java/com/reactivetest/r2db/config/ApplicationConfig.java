package com.reactivetest.r2db.config;


 import javax.persistence.EntityManagerFactory;
 import javax.sql.DataSource;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.jdbc.datasource.DriverManagerDataSource;
 import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
 import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
 import org.springframework.orm.jpa.JpaTransactionManager;
 import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
 import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
 import org.springframework.transaction.PlatformTransactionManager;
 import org.springframework.transaction.annotation.EnableTransactionManagement;

 @Configuration
 @EnableJpaRepositories(basePackages = "com.reactivetest.r2db")
 @EnableTransactionManagement
 class ApplicationConfig {

   @Bean
   public DataSource dataSource() {

       DriverManagerDataSource driver = new DriverManagerDataSource();
       driver.setDriverClassName("org.postgresql.Driver");
       driver.setUrl("jdbc:postgresql://localhost:5432/postgres");
       driver.setUsername("postgres");
       driver.setPassword("*******");
       return driver;

   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

     HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
     vendorAdapter.setGenerateDdl(true);

     LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
     factory.setJpaVendorAdapter(vendorAdapter);
     factory.setPackagesToScan("com.reactivetest.r2db");
     factory.setDataSource(dataSource());
     return factory;
   }

   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

     JpaTransactionManager txManager = new JpaTransactionManager();
     txManager.setEntityManagerFactory(entityManagerFactory);
     return txManager;
   }

   

 }

