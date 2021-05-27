package com.learnjava.rest.webservice.restfulwebservices;


import com.learnjava.rest.webservice.restfulwebservices.dao.jpa.CourseRepository;
import com.learnjava.rest.webservice.restfulwebservices.dao.jpa.PassportRepository;
import com.learnjava.rest.webservice.restfulwebservices.dao.jpa.PersonJpaRepository;
import com.learnjava.rest.webservice.restfulwebservices.dao.jpa.StudentRepository;
import com.learnjava.rest.webservice.restfulwebservices.entity.Course;
import com.learnjava.rest.webservice.restfulwebservices.entity.Passport;
import com.learnjava.rest.webservice.restfulwebservices.entity.Person;
import com.learnjava.rest.webservice.restfulwebservices.entity.Student;
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

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJpaRepository jpaRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private EntityManager entityManager;



    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
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
    @Transactional
    public void run(String... args) throws Exception {
        testStudent();



    }


    @Transactional
    public void testStudent(){
        Passport p1=new Passport("E123456");
        Passport p2=new Passport("F124446");

        Student s1=new Student("Abhi");
        s1.setPassport(p1);

        Student s2=new Student("Laxu");
        s2.setPassport(p2);



        studentRepository.save(s1);
        studentRepository.save(s2);




        //passportRepository.deleteById(2L);
        List<Student> all = studentRepository.findAll();
        System.out.println(all.size());
        System.out.println(all.get(0).getPassport());


    }


    public void testCourse(){
        logger.info("!!!!!!!!!!!!!!!!!!Fetching Course details!!!!!!!!!!!!");
        Course c=courseRepository.findById(10001);
        logger.info("Course Details->{}",c);

        logger.info("!!!!!!!!!!!!!!!!!!Inserting Course!!!!!!!!!!!!!!!!");
        logger.info("Inserted Course->{}",courseRepository.save(new Course(101L,"Spring Boot")));


        logger.info("!!!!!!!!!!!!!!!!!!Updating Course!!!!!!!!!!!!!");
        logger.info("Updated Course->{}",courseRepository.save(new Course(102L,"Java")));

        logger.info("!!!!!!!!!!!!!!!!!!Inserting Course with Id null!!!!!!!!!!!!!!!!");
        logger.info("Inserted Course->{}",courseRepository.save(new Course("Hibernate")));


        // logger.info("!!!!!!!!!!!!!!!!!!Deleting Person!!!!!!!!!!!!!!!!");
        // courseRepository.deleteById(1L);

        logger.info("!!!!!!!!!!!!!!!!!!Fetching ALL Course!!!!!!!!!!!!!!!!");
        courseRepository.findAll().forEach(a->logger.info(a.toString()));
    }

    public void testPerson(){
        logger.info("!!!!!!!!!!!!!!!!!!Fetching details");
        Person p=jpaRepository.findById(10001);
        logger.info("Person Details->{}",p);

        logger.info("!!!!!!!!!!!!!!!!!!Inserting Person!!!!!!!!!!!!!!!!");
        logger.info("Inserted Peson->{}",jpaRepository.update(new Person(10008,"Mohan","Patna",new Date())));


        logger.info("!!!!!!!!!!!!!!!!!!Updating Person!!!!!!!!!!!!!");
        logger.info("Updated Peson->{}",jpaRepository.update(new Person(10003,"Monu","Mugeli",new Date())));

        logger.info("!!!!!!!!!!!!!!!!!!Inserting Person with Id null!!!!!!!!!!!!!!!!");
        logger.info("Inserted Peson->{}",jpaRepository.update(new Person("Sonu","Patna",new Date())));


        logger.info("!!!!!!!!!!!!!!!!!!Deleting Person!!!!!!!!!!!!!!!!");
        logger.info("Deleted Peson->{}",jpaRepository.delete(2));

        logger.info("!!!!!!!!!!!!!!!!!!Fetching ALL Person!!!!!!!!!!!!!!!!");
        jpaRepository.findAll().forEach(a->logger.info(a.toString()));
    }

}
