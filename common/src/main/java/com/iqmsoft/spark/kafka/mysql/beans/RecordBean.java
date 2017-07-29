
package com.iqmsoft.spark.kafka.mysql.beans;

import java.io.Serializable;

public class RecordBean implements Serializable {
    public enum Types {
        africa, asia, europe, north_america, oceania, south_america;

        public static Types fromNumeric(int index) {
            switch (index) {
                default:
                    return null;
                case 0:
                    return Types.africa;
                case 1:
                    return Types.asia;
                case 2:
                    return Types.europe;
                case 3:
                    return Types.north_america;
                case 4:
                    return Types.oceania;
                case 5:
                    return Types.south_america;
            }
        }
    }

    private Types type;

    private float value;

    public RecordBean() {
        // default constructor for default instantiate
    }

    public RecordBean(Types type, float value) {
        this.type = type;
        this.value = value;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}