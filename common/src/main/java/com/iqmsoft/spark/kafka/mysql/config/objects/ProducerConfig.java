
package com.iqmsoft.spark.kafka.mysql.config.objects;

import java.util.List;

public class ProducerConfig {
    private List<String> hosts;

    private int batchSize;

    private String topic;

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}