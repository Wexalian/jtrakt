package com.wexalian.jtrakt.http.query;

import java.util.HashMap;

public enum Genre
{
    ACTION("action"),
    ADVENTURE("adventure"),
    ANIMATION("animation"),
    ANIME("anime"),
    COMEDY("comedy"),
    CRIME("crime"),
    DISASTER("disaster"),
    DOCUMENTARY("documentary"),
    DRAMA("drama"),
    EASTERN("eastern"),
    FAMILY("family"),
    FAN_FILM("fan-film"),
    FANTASY("fanatasy"),
    FILM_NOIR("film-noir"),
    HISTORY("history"),
    HOLIDAY("holiday"),
    HORROR("horror"),
    INDIE("indie"),
    MUSIC("music"),
    MUSICAL("musical"),
    MYSTERY("mystery"),
    NONE("none"),
    ROAD("road"),
    ROMANCE("romance"),
    SCIENCE_FICTION("science-fiction"),
    SHORT("short"),
    SPORTS("sports"),
    SPORTING_EVENT("sporting-event"),
    SUSPENSE("suspense"),
    THRILLER("thriller"),
    TV_MOVIE("tv-movie"),
    WAR("war"),
    WESTERN("western");
    
    private static final HashMap<String, Genre> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (Genre genre : values())
        {
            STRING_MAPPING.put(genre.toString(), genre);
        }
    }
    
    private final String slug;
    
    Genre(String slug)
    {
        this.slug = slug;
    }
    
    @Override
    public String toString()
    {
        return getSlug();
    }
    
    public String getSlug()
    {
        return slug;
    }
    
    public static Genre fromSlug(String slug)
    {
        return STRING_MAPPING.get(slug);
    }
}
