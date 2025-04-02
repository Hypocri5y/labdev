package com.jeffrey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.jeffrey.lab")
@MapperScan("com.jeffrey.lab.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);

    }
}
