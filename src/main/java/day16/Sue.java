package day16;

import java.util.Map;

public class Sue {
    public final int number;
    public final Map<String, Integer> properties;

    public Sue(int number, Map<String, Integer> properties) {
        this.number = number;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Sue [" + number + "]";
    }

}
