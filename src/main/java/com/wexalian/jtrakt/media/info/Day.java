package com.wexalian.jtrakt.media.info;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Day
{
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");
    
    private static final Map<String, Day> STRING_MAPPING = new HashMap<>();
    
    static
    {
        Arrays.stream(Day.values()).forEach(day -> STRING_MAPPING.put(day.toString(), day));
    }
    
    private String name;
    
    Day(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
    public static Day fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
