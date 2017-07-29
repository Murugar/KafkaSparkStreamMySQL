
package com.iqmsoft.spark.kafka.mysql.config.objects;

public class StreamingConfig {
    private StreamingDbConfig db;

    private int window;

    public StreamingDbConfig getDb() {
        return db;
    }

    public void setDb(StreamingDbConfig db) {
        this.db = db;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }
}