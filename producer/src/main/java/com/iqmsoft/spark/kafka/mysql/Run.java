
package com.iqmsoft.spark.kafka.mysql;

import com.iqmsoft.spark.kafka.mysql.beans.RecordBean;
import com.iqmsoft.spark.kafka.mysql.config.ConfigurationFactory;
import com.iqmsoft.spark.kafka.mysql.config.objects.Config;
import com.iqmsoft.spark.kafka.mysql.producer.Producer;
import com.iqmsoft.spark.kafka.mysql.utils.JsonUtils;

import org.apache.log4j.Logger;

import java.util.Random;

public class Run {
    private static final Logger LOGGER = Logger.getLogger(Run.class);

    private static final Random RANDOM = new Random();

    private static final Config CONFIG = ConfigurationFactory.load();

    public static void main(String[] args) {
        final Producer producer = new Producer();

        // catches ctrl+c action
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("Generator application stopping ...");

            producer.close();
        }));

        // sleep time as milliseconds for each step
        int sleep = RANDOM.nextInt(CONFIG.getGenerator().getRandomRange()) + 10;

        RecordBean record;
        while (true) {
            try {
                record = generate();
                producer.produce(record.getType().name(), JsonUtils.serialize(record));

                Thread.sleep(sleep);
            } catch (Throwable t) {
                LOGGER.error(t.getMessage(), t);
            }
        }
    }

    /**
     * Generates random record
     *
     * @return Returns record object with random values
     */
    private static RecordBean generate() {
        RecordBean data = new RecordBean();
        data.setType(RecordBean.Types.fromNumeric(RANDOM.nextInt(6)));
        data.setValue(RANDOM.nextFloat() * 1000);

        return data;
    }
}