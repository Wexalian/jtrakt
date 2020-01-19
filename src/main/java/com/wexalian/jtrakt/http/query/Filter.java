package com.wexalian.jtrakt.http.query;

import com.wexalian.jtrakt.media.info.Certification;
import com.wexalian.jtrakt.media.info.Status;

public class Filter<T>
{
    //common filters
    public static final Filter<String> QUERY = new Filter<>("query", false);
    public static final Filter<Range> YEARS = new Filter<>("years", false);
    public static final Filter<Genre[]> GENRES = new Filter<>("genres", true);
    public static final Filter<Language> LANGUAGES = new Filter<>("languages", true);
    public static final Filter<String> COUNTRIES = new Filter<>("countries", true); //TODO Change to enum?
    public static final Filter<Range> RUNTIMES = new Filter<>("runtimes", false);
    public static final Filter<Range> RATINGS = new Filter<>("ratings", false);
    public static final Filter<Certification> CERTIFICATIONS = new Filter<>("certifications", true);
    
    //show filters
    public static final Filter<String> NETWORKS = new Filter<>("networks", true);
    public static final Filter<Status> STATUS = new Filter<>("status", true);
    
    //search filters
    public static final Filter<String> SEARCH_FIELDS = new Filter<>("fields", true);
    
    private final String parameter;
    private final boolean multiples;
    
    private Filter(String parameter, boolean multiples)
    {
        this.parameter = parameter;
        this.multiples = multiples;
    }
    
    public FilterEntry<T> withValue(T value)
    {
        return new FilterEntry<>(this, value);
    }
    
    public boolean multiplesAllowed()
    {
        return multiples;
    }
    
    public String getParameter()
    {
        return parameter;
    }
    
    public static class FilterEntry<T>
    {
        private final Filter<T> filter;
        private final T value;
        
        private FilterEntry(Filter<T> filter, T value)
        {
            this.filter = filter;
            this.value = value;
        }
        
        public Filter<T> getFilter()
        {
            return filter;
        }
        
        public T getValue()
        {
            return value;
        }
    }
}
