package com.yanhua365.learn.spring.batch.simple;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableBatchProcessing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // If you would like to configure your own batch infrastructure via BatchConfigurer,
    // just add a bean of that type to the ApplicationContext, like in the following code.
    // This starter's implementation will step aside then.
    //    @Bean
    //    public BatchConfigurer batchConfigurer(DataSource dataSource){
    //    	return new DefaultBatchConfigurer(dataSource);
    //    }
}
