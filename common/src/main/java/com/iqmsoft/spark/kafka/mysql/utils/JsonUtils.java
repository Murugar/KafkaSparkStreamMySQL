
package com.iqmsoft.spark.kafka.mysql.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Returns object as JSON encoded string
     *
     * @param input the bean instance
     * @return Returns single line JSON string
     */
    public static String serialize(Object input) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(input);
    }

    /**
     * Returns JSON encoded string as real object
     *
     * @param input the encoded JSON string
     * @return Returns PoJo
     */
    public static <T> T deserialize(String input, Class<T> tClass) throws IOException {
        return OBJECT_MAPPER.readValue(input, tClass);
    }
}