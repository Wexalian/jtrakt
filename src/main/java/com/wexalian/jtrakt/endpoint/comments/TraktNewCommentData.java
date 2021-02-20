package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.TraktSharing;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

public class TraktNewCommentData {
    private final String comment;
    private final boolean spoiler;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private TraktList list;
    private TraktSharing sharing;
    
    public TraktNewCommentData(TraktMovie movie, String comment, boolean spoiler, TraktSharing sharing) {
        this.movie = movie;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktNewCommentData(TraktShow show, String comment, boolean spoiler, TraktSharing sharing) {
        this.show = show;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktNewCommentData(TraktSeason season, String comment, boolean spoiler, TraktSharing sharing) {
        this.season = season;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktNewCommentData(TraktEpisode episode, String comment, boolean spoiler, TraktSharing sharing) {
        this.episode = episode;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktNewCommentData(TraktList list, String comment, boolean spoiler, TraktSharing sharing) {
        this.list = list;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktNewCommentData(String comment, boolean spoiler) {
        this.comment = comment;
        this.spoiler = spoiler;
    }
}
