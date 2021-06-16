package com.epam.esm.config;

import com.epam.esm.model.dao.impl.GiftCertDAOImpl;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.dao.impl.TagGiftCertDAOImpl;
import com.epam.esm.service.GiftCertService;
import com.epam.esm.service.TagGiftCertService;
import com.epam.esm.service.TagService;
import com.epam.esm.service.impl.GiftCertServiceImpl;
import com.epam.esm.service.impl.TagGiftCertServiceImpl;
import com.epam.esm.service.impl.TagServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
/**
 * Configuration class of Spring
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.epam.esm")
public class SpringMvcConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gct_db?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public TagService getTagService(){
        return new TagServiceImpl( new TagDAOImpl(getDataSource()));
    }

    @Bean
    public GiftCertService getGiftCertService(){
        return new GiftCertServiceImpl( new GiftCertDAOImpl(getDataSource()));
    }

    @Bean
    public TagGiftCertService getTagGiftCertService(){
        return new TagGiftCertServiceImpl( new TagGiftCertDAOImpl(getDataSource()));
    }

}
