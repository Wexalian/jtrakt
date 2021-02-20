package com.wexalian.jtrakt.endpoint.genres;

import java.util.HashMap;

public enum TraktGenre {
    ACTION("action", "Action"),
    ADVENTURE("adventure", "Adventure"),
    ANIMATION("animation", "Animation"),
    ANIME("anime", "Anime"),
    COMEDY("comedy", "Comedy"),
    CRIME("crime", "Crime"),
    DISASTER("disaster", ""),
    DOCUMENTARY("documentary", "Documentary"),
    DRAMA("drama", "Drama"),
    EASTERN("eastern", "Eastern"),
    FAMILY("family", "Family"),
    FAN_FILM("fan-film", "Fan Film"),
    FANTASY("fantasy", "Fantasy"),
    FILM_NOIR("film-noir", "Film Noir"),
    HISTORY("history", "History"),
    HOLIDAY("holiday", "Holiday"),
    HORROR("horror", "Horror"),
    INDIE("indie", "indie"),
    MUSIC("music", "Music"),
    MUSICAL("musical", "Musical"),
    MYSTERY("mystery", "Mystery"),
    NONE("none", "None"),
    ROAD("road", "Road"),
    ROMANCE("romance", "Romance"),
    SCIENCE_FICTION("science-fiction", "Science Fiction"),
    SHORT("short", "Short"),
    SPORTS("sports", "Sports"),
    SPORTING_EVENT("sporting-event", "Sporting Event"),
    SUSPENSE("suspense", "Suspense"),
    THRILLER("thriller", "Thriller"),
    TV_MOVIE("tv-movie", "TV Movie"),
    WAR("war", "War"),
    WESTERN("western", "Western");
    
    private static final HashMap<String, TraktGenre> STRING_MAPPING = new HashMap<>();
    
    static {
        for (TraktGenre genre : values()) {
            STRING_MAPPING.put(genre.toString(), genre);
        }
    }
    
    private final String slug;
    private final String name;
    
    TraktGenre(String slug, String name) {
        this.slug = slug;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSlug() {
        return slug;
    }
    
    public static TraktGenre fromSlug(String slug) {
        return STRING_MAPPING.get(slug);
    }
    
    @Override
    public String toString() {
        return getSlug();
    }
}
