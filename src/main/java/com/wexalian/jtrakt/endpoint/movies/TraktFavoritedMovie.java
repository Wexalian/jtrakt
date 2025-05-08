package com.wexalian.jtrakt.endpoint.movies;

public class TraktFavoritedMovie {
    private int user_count;
    private TraktMovie movie;
    
    public int getUserCount() {
        return user_count;
    }
    
    public TraktMovie getMovie() {
        return movie;
    }
}
