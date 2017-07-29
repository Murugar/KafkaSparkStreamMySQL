
package com.iqmsoft.spark.kafka.mysql.config.objects;

public class Config {
    private ProducerConfig producer;

    private GeneratorConfig generator;

    private WebConfig web;

    private StreamingConfig streaming;

    public ProducerConfig getProducer() {
        return producer;
    }

    public void setProducer(ProducerConfig producer) {
        this.producer = producer;
    }

    public GeneratorConfig getGenerator() {
        return generator;
    }

    public void setGenerator(GeneratorConfig generator) {
        this.generator = generator;
    }

    public WebConfig getWeb() {
        return web;
    }

    public void setWeb(WebConfig web) {
        this.web = web;
    }

    public StreamingConfig getStreaming() {
        return streaming;
    }

    public void setStreaming(StreamingConfig streaming) {
        this.streaming = streaming;
    }
}