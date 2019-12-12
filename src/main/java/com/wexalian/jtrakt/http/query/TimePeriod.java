package com.wexalian.jtrakt.http.query;

public enum TimePeriod
{
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly"),
    ALL("all");
    
    private final String name;
    
    TimePeriod(String name)
    {
        
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
    
    public String getName()
    {
        return name;
    }
}
