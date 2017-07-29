
package com.iqmsoft.spark.kafka.mysql.http.responses;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MetricResponse {
    public static class Metric {
        private String market;

        private float rate;

        private long date;

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }
    }

    private List<Metric> metrics;

    private Timestamp lastTime;

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public void addMetric(Metric metric) {
        if (metrics == null) {
            metrics = new ArrayList<>();
        }

        metrics.add(metric);
    }

    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }
}