package com.wexalian.jtrakt.endpoint;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class TraktAirsInfo {
    public Day day;
    public LocalTime time;
    public ZoneId timezone;
    
    public Day getDay() {
        return day;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public ZoneId getTimezone() {
        return timezone;
    }
    
    public enum Day {
        MONDAY("Monday"),
        TUESDAY("Tuesday"),
        WEDNESDAY("Wednesday"),
        THURSDAY("Thursday"),
        FRIDAY("Friday"),
        SATURDAY("Saturday"),
        SUNDAY("Sunday");
        
        private static final Map<String, Day> STRING_MAPPING = new HashMap<>();
        
        static {
            for (Day day : Day.values()) {
                STRING_MAPPING.put(day.toString(), day);
            }
        }
        
        private final String name;
        
        Day(String name) {
            this.name = name;
        }
        
        public static Day fromValue(String value) {
            return STRING_MAPPING.get(value);
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
}
