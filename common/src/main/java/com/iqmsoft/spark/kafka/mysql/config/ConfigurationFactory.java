
package com.iqmsoft.spark.kafka.mysql.config;

import com.google.common.base.Strings;
import com.iqmsoft.spark.kafka.mysql.config.objects.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ConfigurationFactory {
    /**
     * Loads configuration object by file
     *
     * @return Returns configuration objects
     */
    public static Config load() {
        if (Strings.isNullOrEmpty(System.getProperty("config"))) {
            throw new RuntimeException("Configuration file path is empty. "
                    + "Please specify the file path with using -Dconfig=[PATH]");
        }

        com.typesafe.config.Config config
                = ConfigFactory.parseFile(new File(System.getProperty("config")));

        return ConfigBeanFactory.create(config, Config.class);
    }
}