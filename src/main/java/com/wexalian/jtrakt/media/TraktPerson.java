package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

import java.util.List;

public class TraktPerson
{
    private String name;
    private Ids ids;
    
    public TraktPerson() {}
    
    public TraktPerson(String name, Ids ids)
    {
        this.name = name;
        this.ids = ids;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Ids getIds()
    {
        return ids;
    }
    
    public static class CastMember
    {
        private List<String> characters;
        private int episode_count;
        private TraktPerson person;
        
        public List<String> getCharacters()
        {
            return characters;
        }
        
        public int getEpisodeCount()
        {
            return episode_count;
        }
        
        public TraktPerson getPerson()
        {
            return person;
        }
    }
    
    public static class CrewMember
    {
        private List<String> jobs;
        private int episode_count;
        private TraktPerson person;
        
        public List<String> getJobs()
        {
            return jobs;
        }
        
        public int getEpisodeCount()
        {
            return episode_count;
        }
        
        public TraktPerson getPerson()
        {
            return person;
        }
    }
}
