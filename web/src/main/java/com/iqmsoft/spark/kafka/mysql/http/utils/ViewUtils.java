
package com.iqmsoft.spark.kafka.mysql.http.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

public class ViewUtils {
    private static final String PREFIX = "views/";

    private static final String SUFFIX = ".html";

    public static String render(String name) throws IOException {
        return Resources.toString(Resources.getResource(PREFIX + name + SUFFIX), Charsets.UTF_8);
    }
}