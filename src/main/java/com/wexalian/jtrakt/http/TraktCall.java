package com.wexalian.jtrakt.http;

import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;

import java.util.HashMap;
import java.util.Map;

public class TraktCall
{
    private final String endpoint;
    private final Map<String, String> pathVars = new HashMap<>();
    private final Map<String, String> queryVars = new HashMap<>();
    
    private TraktCall(String endpoint)
    {
        this.endpoint = endpoint;
    }
    
    public TraktCall path(String pathVar, String var)
    {
        pathVars.put(pathVar, var);
        return this;
    }
    
    public TraktCall extended(Extended extended)
    {
        if (extended == null) return this;
        
        queryVars.put("extended", extended.toString());
        
        return this;
    }
    
    public TraktCall pagination(Pagination pagination)
    {
        if (pagination == null) return this;
        
        queryVars.put("page", pagination.getPage() + "");
        queryVars.put("limit", pagination.getLimit() + "");
        return this;
    }
    
    public String getUrlString()
    {
        String formattedEndpoint = endpoint;
        for (Map.Entry<String, String> entry : pathVars.entrySet())
        {
            formattedEndpoint = formattedEndpoint.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        
        int index = 0;
        String[] queries = new String[queryVars.size()];
        for (Map.Entry<String, String> entry : queryVars.entrySet())
        {
            queries[index++] = entry.getKey() + "=" + entry.getValue();
        }
        String formattedQuery = String.join(",", queries);
        // String encodedQuery = URLEncoder.encode(formattedQuery, StandardCharsets.UTF_8);
        
        return TraktHTTP.API_URL + formattedEndpoint + "?" + formattedQuery;
        
    }
    
    public static TraktCall create(String endpoint)
    {
        return new TraktCall(endpoint);
    }
}
