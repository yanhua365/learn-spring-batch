package com.yanhua365.learn.spring.batch.multi_threads_step.item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;

/**
 * {@link ItemReader} with hard-coded input data.
 */
public class DummyItemReader implements ItemReader<String> {
	
	private static final Log log = LogFactory.getLog(DummyItemReader.class);
	
	private String[] input = {"Good", "morning!","This","is","your","ItemReader","speaking!"};
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
 	//public String read() throws Exception {
    public synchronized String read() throws Exception {
		String item;
		if (index < 100000) {
			index++;
			item = "hello" + index;
			log.info(item);
			return item;
		}
		else {
			return null;
		}
		
	}

}
