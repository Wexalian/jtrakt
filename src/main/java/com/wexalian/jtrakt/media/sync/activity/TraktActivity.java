package com.wexalian.jtrakt.media.sync.activity;

import java.time.OffsetDateTime;

public class TraktActivity
{
    private OffsetDateTime all;
    private MovieActivity movies;
    private EpisodeActivity episodes;
    private ShowActivity shows;
    private SeasonActivity seasons;
    private CommentActivity comments;
    private ListActivity lists;
    
    public OffsetDateTime getAll()
    {
        return all;
    }
    
    public MovieActivity getMovies()
    {
        return movies;
    }
    
    public EpisodeActivity getEpisodes()
    {
        return episodes;
    }
    
    public ShowActivity getShows()
    {
        return shows;
    }
    
    public SeasonActivity getSeasons()
    {
        return seasons;
    }
    
    public CommentActivity getComments()
    {
        return comments;
    }
    
    public ListActivity getLists()
    {
        return lists;
    }
    
}
