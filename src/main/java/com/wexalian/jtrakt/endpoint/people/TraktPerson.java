package com.wexalian.jtrakt.endpoint.people;

import com.wexalian.jtrakt.endpoint.TraktIds;

import java.time.LocalDate;

public class TraktPerson {
    private String name;
    private TraktIds ids;
    
    private Social social_ids;
    private String biography;
    private LocalDate birthday;
    private LocalDate death;
    private String birthplace;
    private String homepage;
    
    public TraktPerson() {}
    
    public TraktPerson(String name, TraktIds ids) {
        this.name = name;
        this.ids = ids;
    }
    
    public String getName() {
        return name;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    public Social getSocialIds() {
        return social_ids;
    }
    
    public String getBiography() {
        return biography;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public LocalDate getDeath() {
        return death;
    }
    
    public String getBirthplace() {
        return birthplace;
    }
    
    public String getHomepage() {
        return homepage;
    }
    
    public static class Social {
        public String twitter;
        public String facebook;
        public String instagram;
        public String wikipedia;
    }
}
