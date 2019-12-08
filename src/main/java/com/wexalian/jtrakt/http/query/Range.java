package com.wexalian.jtrakt.http.query;

public class Range
{
    private final int year1;
    private final int year2;
    
    private Range(int year1, int year2)
    {
        this.year1 = year1;
        this.year2 = year2;
    }
    
    @Override
    public String toString()
    {
        if (year1 == year2) return "" + year1;
        return year1 + "-" + year2;
    }
    
    public static Range of(int year)
    {
        return new Range(year, year);
    }
    
    public static Range of(int year1, int year2)
    {
        return new Range(year1, year2);
    }
}
