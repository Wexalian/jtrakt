package com.wexalian.jtrakt.endpoint;

public enum TraktPeriod {
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly"),
    ALL("all");
    
    private final String name;
    
    TraktPeriod(String name) {
        
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
