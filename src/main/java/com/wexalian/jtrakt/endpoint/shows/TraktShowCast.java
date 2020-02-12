package com.wexalian.jtrakt.endpoint.shows;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.endpoint.TraktPerson;

import java.util.List;

public class TraktShowCast
{
    private List<CastMember> cast;
    private Crew crew;
    
    public List<CastMember> getCast()
    {
        return cast;
    }
    
    public Crew getCrew()
    {
        return crew;
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
    
    public static class Crew
    {
        private List<CrewMember> production;
        private List<CrewMember> art;
        private List<CrewMember> crew;
        @SerializedName("costume & make-up")
        private List<CrewMember> costume_and_makeup;
        private List<CrewMember> directing;
        private List<CrewMember> writing;
        private List<CrewMember> sound;
        private List<CrewMember> camera;
        @SerializedName("visual effects")
        private List<CrewMember> visual_effects;
    
        public List<CrewMember> getProduction()
        {
            return production;
        }
    
        public List<CrewMember> getArt()
        {
            return art;
        }
    
        public List<CrewMember> getCrew()
        {
            return crew;
        }
    
        public List<CrewMember> getCostumeAndMakeup()
        {
            return costume_and_makeup;
        }
    
        public List<CrewMember> getDirecting()
        {
            return directing;
        }
    
        public List<CrewMember> getWriting()
        {
            return writing;
        }
    
        public List<CrewMember> getSound()
        {
            return sound;
        }
    
        public List<CrewMember> getCamera()
        {
            return camera;
        }
    
        public List<CrewMember> getVisualEffects()
        {
            return visual_effects;
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
