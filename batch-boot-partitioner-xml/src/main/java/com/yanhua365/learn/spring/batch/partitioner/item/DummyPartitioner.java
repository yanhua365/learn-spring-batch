package com.yanhua365.learn.spring.batch.partitioner.item;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanhua on 15/12/28.
 */
public class DummyPartitioner implements Partitioner {

    private static final String PARTITION_KEY = "partition";

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);
        for (int i = 0; i < gridSize; i++) {
            ExecutionContext context = new ExecutionContext();
            context.put("start", i * 50000);
            context.put("end", (i+1) * 50000);

            map.put(PARTITION_KEY+i, context);
        }
        return map;
    }
}
