package com.yanhua365.learn.spring.batch.partitioner;

import org.h2.Driver;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@ImportResource("classpath:spring-batch-job.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "dataSource")
    @Profile("server_db")
    public DataSource getH2ServerDataSource(){
        return new SimpleDriverDataSource(new Driver(), "jdbc:h2:tcp://localhost/~/h2data/batch-partitioner", "sa", "");
    }


    // If you would like to configure your own batch infrastructure via BatchConfigurer,
    // just add a bean of that type to the ApplicationContext, like in the following code.
    // This starter's implementation will step aside then.
    //    @Bean
    //    public BatchConfigurer batchConfigurer(DataSource dataSource){
    //    	return new DefaultBatchConfigurer(dataSource);
    //    }
}
