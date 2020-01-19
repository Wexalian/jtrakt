package com.wexalian.jtrakt.media.sync;

import java.util.List;

public class TraktSyncUpdate<T>
{
    private MoviesEpisodes added;
    private MoviesEpisodes updated;
    private MoviesEpisodes existing;
    private MoviesEpisodes deleted;
    private NotFound<T> not_found;
    
    private static class MoviesEpisodes
    {
        private int movies;
        private int episodes;
        
        public int getMovies()
        {
            return movies;
        }
        
        public int getEpisodes()
        {
            return episodes;
        }
    }
    
    private static class NotFound<T>
    {
        private List<T> movies;
        private List<T> shows;
        private List<T> seasons;
        private List<T> episodes;
        private List<Long> ids;
        
        public List<T> getMovies()
        {
            return movies;
        }
        
        public List<T> getShows()
        {
            return shows;
        }
        
        public List<T> getSeasons()
        {
            return seasons;
        }
        
        public List<T> getEpisodes()
        {
            return episodes;
        }
        
        public List<Long> getIds()
        {
            return ids;
        }
    }
}
