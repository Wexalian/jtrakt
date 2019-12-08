package com.wexalian.jtrakt.media;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TraktCast
{
    private List<TraktPerson.CastMember> cast;
    private Crew crew;
    
    public static class Crew
    {
        private List<TraktPerson.CrewMember> production;
        private List<TraktPerson.CrewMember> art;
        private List<TraktPerson.CrewMember> crew;
        @SerializedName("costume & make-up")
        private List<TraktPerson.CrewMember> costume_and_makeup;
        private List<TraktPerson.CrewMember> directing;
        private List<TraktPerson.CrewMember> writing;
        private List<TraktPerson.CrewMember> sound;
        private List<TraktPerson.CrewMember> camera;
        @SerializedName("visual effects")
        private List<TraktPerson.CrewMember> visual_effects;
        
        public List<TraktPerson.CrewMember> getProduction()
        {
            return production;
        }
        
        public List<TraktPerson.CrewMember> getArt()
        {
            return art;
        }
        
        public List<TraktPerson.CrewMember> getCrew()
        {
            return crew;
        }
        
        public List<TraktPerson.CrewMember> getCostumeAndMakeup()
        {
            return costume_and_makeup;
        }
        
        public List<TraktPerson.CrewMember> getDirecting()
        {
            return directing;
        }
        
        public List<TraktPerson.CrewMember> getWriting()
        {
            return writing;
        }
        
        public List<TraktPerson.CrewMember> getSound()
        {
            return sound;
        }
        
        public List<TraktPerson.CrewMember> getCamera()
        {
            return camera;
        }
        
        public List<TraktPerson.CrewMember> getVisualEffects()
        {
            return visual_effects;
        }
    }
}
