package com.yanhua365.learn.spring.batch.simple.item;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class LogItemWriter implements ItemWriter<String> {

	private static final Log log = LogFactory.getLog(LogItemWriter.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends String> data) throws Exception {
		log.info(data);
	}
}
