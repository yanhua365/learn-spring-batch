package com.yanhua365.learn.spring.batch.simple.job;

import com.yanhua365.learn.spring.batch.simple.item.DummyItemReader;
import com.yanhua365.learn.spring.batch.simple.item.LogItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yanhua365.learn.spring.batch.simple.item.LogItemWriter;

@Configuration
public class SimpleJobConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job(){
		return jobBuilderFactory.get("job")
				.start(step())
				.build();
	}
	
	@Bean
	public Step step(){
		return stepBuilderFactory.get("step")
				.<String,String>chunk(2)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public LogItemWriter writer() {
		return new LogItemWriter();
	}

	@Bean
	public LogItemProcessor processor() {
		return new LogItemProcessor();
	}

	@Bean
	public DummyItemReader reader() {
		return new DummyItemReader();
	}
	
}
