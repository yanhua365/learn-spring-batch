package com.yanhua365.learn.spring.batch.simple;

import org.h2.Driver;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    @Profile("mem_db")
    public DataSource getH2MemDataSource(){
        return new SimpleDriverDataSource(new Driver(), "jdbc:h2:mem:learn_batch_file2file", "sa", "");
    }


    @Bean(name = "dataSource")
    @Profile("server_db")
    public DataSource getH2ServerDataSource(){
        return new SimpleDriverDataSource(new Driver(), "jdbc:h2:tcp://localhost/~/h2data/batch-simple", "sa", "");
    }


    // If you would like to configure your own batch infrastructure via BatchConfigurer,
    // just add a bean of that type to the ApplicationContext, like in the following code.
    // This starter's implementation will step aside then.
    //    @Bean
    //    public BatchConfigurer batchConfigurer(DataSource dataSource){
    //    	return new DefaultBatchConfigurer(dataSource);
    //    }
}
