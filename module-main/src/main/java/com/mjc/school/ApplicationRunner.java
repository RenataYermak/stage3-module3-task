package com.mjc.school;

import com.mjc.school.menu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        Menu menu = context.getBean(Menu.class);
        context.getBean(EntityManager.class);
        menu.run();
    }
}
