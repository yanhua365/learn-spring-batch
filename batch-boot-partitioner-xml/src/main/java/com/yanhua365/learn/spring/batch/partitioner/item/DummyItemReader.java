package com.yanhua365.learn.spring.batch.partitioner.item;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;

/**
 * {@link ItemReader} with hard-coded input data.
 */
public class DummyItemReader implements ItemReader<String> {
	
	private static final Log log = LogFactory.getLog(DummyItemReader.class);
	

	private Integer start;

	private Integer end;

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}


	/**
	 * Reads next record from input
	 */
    public String read() throws Exception {
		String item;
		if (start < end) {
			start++;
			item = "hello" + start;
			log.info(item);
			return item;
		}
		else {
			return null;
		}
		
	}

}
