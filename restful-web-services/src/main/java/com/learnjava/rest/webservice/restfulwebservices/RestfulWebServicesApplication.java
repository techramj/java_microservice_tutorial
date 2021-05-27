package com.learnjava.rest.webservice.restfulwebservices;

import com.learnjava.rest.webservice.restfulwebservices.dao.Jdbc.PersonJdbcDao;
import com.learnjava.rest.webservice.restfulwebservices.dao.jpa.PersonJpaRepository;
import com.learnjava.rest.webservice.restfulwebservices.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

//@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao  jdbcDao;


    public static void main(String[] args) {
       // SpringApplication.run(RestfulWebServicesApplication.class, args);
    }


    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    public void run(String... args) throws Exception {

        //jdbcDemo();


    }

    public void jdbcDemo(){
        logger.info("Runner start");
        List<Person> person=jdbcDao.findAll();
        jdbcDao.findAll().stream().forEach(a->logger.info(a+"\n"));

        logger.info("Find by Id!!!!!!!!!!!!!!!!");
        logger.info("Details for id: "+jdbcDao.findById(1));
    }
}
