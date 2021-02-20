package com.wexalian.jtrakt.endpoint;

public enum TraktTimePeriod {
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly"),
    ALL("all");
    
    private final String name;
    
    TraktTimePeriod(String name) {
        
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
