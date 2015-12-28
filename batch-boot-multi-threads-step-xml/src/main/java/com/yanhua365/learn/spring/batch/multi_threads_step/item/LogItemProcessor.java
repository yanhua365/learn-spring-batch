package com.yanhua365.learn.spring.batch.multi_threads_step.item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;


/**
 * Dummy {@link ItemProcessor} which adds a '$' prefix to the data it receives.
 */
public class LogItemProcessor implements ItemProcessor<String,String> {

	private static final Log log = LogFactory.getLog(LogItemProcessor.class);
	
	public String process(String item) throws Exception {
		Thread.sleep(2000);
		log.info("processor :" + item);
		return "$" + item;
	}

}
