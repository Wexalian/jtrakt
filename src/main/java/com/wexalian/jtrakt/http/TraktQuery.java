package com.wexalian.jtrakt.http;

import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Filter;
import com.wexalian.jtrakt.http.query.Pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraktQuery
{
    private final String endpoint;
    
    private HashMap<String, String> pathVars = new HashMap<>();
    private HashMap<String, String> queryVars = new HashMap<>();
    private Extended extended = null;
    private Pagination pagination = null;
    private HashMap<Filter, List<String>> filters = new HashMap<>();
    
    private TraktQuery(String endpoint)
    {
        this.endpoint = endpoint;
    }
    
    public TraktQuery path(String pathVar, Object varValue)
    {
        String value = varValue == null ? "" : varValue.toString();
        pathVars.put(pathVar, value);
        return this;
    }
    
    public TraktQuery query(String queryVar, Object varValue)
    {
        String value = varValue == null ? "" : varValue.toString();
        queryVars.put(queryVar, value);
        return this;
    }
    
    public TraktQuery query(Extended extended)
    {
        this.extended = extended;
        return this;
    }
    
    public TraktQuery query(Pagination pagination)
    {
        this.pagination = pagination;
        return this;
    }
    
    public final TraktQuery query(Filter.FilterEntry... filterEntries)
    {
        if (filterEntries == null || filterEntries.length == 0) return this;
    
        for (Filter.FilterEntry filterEntry : filterEntries)
        {
            Filter filter = filterEntry.getFilter();
            Object value = filterEntry.getValue();
            
            List<String> values = filters.get(filter);
            if (values == null)
            {
                values = new ArrayList<>();
                values.add(value.toString());
                filters.put(filter, values);
            }
            else if (filter.multiplesAllowed())
            {
                values.add(value.toString());
            }
        }
        return this;
    }
    
    public String format()
    {
        String endpoint = this.endpoint;
        for (Map.Entry<String, String> entry : pathVars.entrySet())
        {
            endpoint = endpoint.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        
        endpoint = endpoint.replace("//", "/");
        
        List<String> fullQueryVars = new ArrayList<>();
        
        if (extended != null)
        {
            fullQueryVars.add("extended=" + extended.toString());
        }
        if (pagination != null)
        {
            fullQueryVars.add("page=" + pagination.getPage());
            fullQueryVars.add("limit=" + pagination.getLimit());
        }
        
        filters.forEach((f, v) -> fullQueryVars.add(f.getParameter() + "=" + String.join(",", v)));
        queryVars.forEach((k, v) -> fullQueryVars.add(k + "=" + v));
        
        String query = "";
        if (!fullQueryVars.isEmpty())
        {
            query = "?" + String.join("&", fullQueryVars);
        }
        
        return TraktHTTP.API_URL + endpoint + query;
    }
    
    public static TraktQuery create(String endpoint)
    {
        return new TraktQuery(endpoint);
    }
}
