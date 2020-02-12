package com.wexalian.jtrakt.endpoint.sync;

import java.util.ArrayList;
import java.util.List;

public class TraktSyncItems<T>
{
    private List<T> movies = new ArrayList<>();
    private List<T> shows = new ArrayList<>();
    private List<T> seasons = new ArrayList<>();
    private List<T> episodes = new ArrayList<>();
    private List<T> people = new ArrayList<>();
    private List<Long> ids = new ArrayList<>();
    
    public void addMovie(T movie)
    {
        movies.add(movie);
    }
    
    public void addShow(T show)
    {
        shows.add(show);
    }
    
    public void addSeason(T season)
    {
        seasons.add(season);
    }
    
    public void addEpisode(T episode)
    {
        episodes.add(episode);
    }
    
    public void addPeople(T person)
    {
        people.add(person);
    }
    
    public void addHistoryId(long id)
    {
        ids.add(id);
    }
}
