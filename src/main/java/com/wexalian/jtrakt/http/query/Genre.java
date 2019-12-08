package com.wexalian.jtrakt.http.query;

import java.util.Arrays;
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
    
    private final String slug;
    
    private static final HashMap<String, Genre> SLUG_TO_GENRE = new HashMap<>();
    
    static
    {
        Arrays.stream(Genre.values()).forEach(genre -> SLUG_TO_GENRE.put(genre.getSlug(), genre));
    }
    
    Genre(String slug)
    {
        this.slug = slug;
    }
    
    public String getSlug()
    {
        return slug;
    }
    
    @Override
    public String toString()
    {
        return getSlug();
    }
    
    public static Genre fromSlug(String slug)
    {
        return SLUG_TO_GENRE.get(slug);
    }
}
