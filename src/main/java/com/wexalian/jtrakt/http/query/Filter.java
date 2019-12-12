package com.wexalian.jtrakt.http.query;

import com.wexalian.jtrakt.media.info.Status;

public class Filter<T>
{
    //common filters
    public static final Filter<String> QUERY = new Filter<>("query", false);
    public static final Filter<Range> YEARS = new Filter<>("years", false);
    public static final Filter<Genre[]> GENRES = new Filter<>("genres", true);
    public static final Filter<Language> LANGUAGES = new Filter<>("languages", true);
    // TODO maybe? public static final Filter<String> COUNTRIES = new Filter<>("countries", true);
    public static final Filter<Range> RUNTIMES = new Filter<>("runtimes", false);
    public static final Filter<Range> RATINGS = new Filter<>("ratings", false);
    // TODO maybe? public static final Filter<ContentCertification> CERTIFICATIONS = new Filter<>("certifications", true);
    
    //show filters
    // TODO maybe? public static final Filter<Network> NETWORKS = new Filter<Network>("networks", true);
    public static final Filter<Status> STATUS = new Filter<Status>("status", true);
    
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
