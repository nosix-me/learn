package com.moji.flume.extension.kafka;

import kafka.producer.Partitioner;

public class MojiHashPartitioner implements Partitioner {

	public int partition(Object key, int numPartitions) {
		int partition = 0;
		String k = (String)key;
		partition = Math.abs(k.hashCode()) % numPartitions;
		return partition;
	}
}
