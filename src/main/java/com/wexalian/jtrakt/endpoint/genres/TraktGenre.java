package com.wexalian.jtrakt.endpoint.genres;

import java.util.HashMap;

public enum TraktGenre {
    ACTION("action", "Action"),
    ADVENTURE("adventure", "Adventure"),
    ANIMATION("animation", "Animation"),
    ANIME("anime", "Anime"),
    BIOGRAPHY("biography", "Biography"),
    CHILDREN("children", "Children"),
    COMEDY("comedy", "Comedy"),
    CRIME("crime", "Crime"),
    // DISASTER("disaster", "Disaster"),
    DOCUMENTARY("documentary", "Documentary"),
    DONGHUA("donghua", "Donghua"),
    DRAMA("drama", "Drama"),
    // EASTERN("eastern", "Eastern"),
    FAMILY("family", "Family"),
    // FAN_FILM("fan-film", "Fan Film"),
    FANTASY("fantasy", "Fantasy"),
    // FILM_NOIR("film-noir", "Film Noir"),
    GAME_SHOW("game-show", "Game Show"),
    HISTORY("history", "History"),
    HOLIDAY("holiday", "Holiday"),
    HOME_AND_GARDEN("home-and-garden", "Home And Garden"),
    HORROR("horror", "Horror"),
    // INDIE("indie", "indie"),
    MINI_SERIES("mini-series", "Mini Series"),
    MUSIC("music", "Music"),
    MUSICAL("musical", "Musical"),
    MYSTERY("mystery", "Mystery"),
    NEWS("news", "News"),
    NONE("none", "None"),
    // ROAD("road", "Road"),
    REALITY("reality", "Reality"),
    ROMANCE("romance", "Romance"),
    SCIENCE_FICTION("science-fiction", "Science Fiction"),
    SHORT("short", "Short"),
    // SPORTS("sports", "Sports"),
    SOAP("soap", "Soap"),
    SPECIAL_INTEREST("special-interest", "Special Interest"),
    SPORTING_EVENT("sporting-event", "Sporting Event"),
    SUPERHERO("superhero", "Superhero"),
    SUSPENSE("suspense", "Suspense"),
    TALK_SHOW("talk-show", "Talk Show"),
    THRILLER("thriller", "Thriller"),
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
        TraktGenre genre = STRING_MAPPING.get(slug);
        if (genre == null) {
            System.out.println("Unknown genre: " + slug);
        }
        return genre;
    }
    
    @Override
    public String toString() {
        return getSlug();
    }
}
