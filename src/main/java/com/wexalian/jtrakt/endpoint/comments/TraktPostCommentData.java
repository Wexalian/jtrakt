package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.*;

public class TraktPostCommentData
{
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private TraktList list;
    
    private String comment;
    private boolean spoiler;
    private TraktSharing sharing;
    
    public TraktPostCommentData(TraktMovie movie, String comment, boolean spoiler, TraktSharing sharing)
    {
        this.movie = movie;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktPostCommentData(TraktShow show, String comment, boolean spoiler, TraktSharing sharing)
    {
        this.show = show;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktPostCommentData(TraktSeason season, String comment, boolean spoiler, TraktSharing sharing)
    {
        this.season = season;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktPostCommentData(TraktEpisode episode, String comment, boolean spoiler, TraktSharing sharing)
    {
        this.episode = episode;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktPostCommentData(TraktList list, String comment, boolean spoiler, TraktSharing sharing)
    {
        this.list = list;
        this.comment = comment;
        this.spoiler = spoiler;
        this.sharing = sharing;
    }
    
    public TraktPostCommentData(String comment, boolean spoiler)
    {
        this.comment = comment;
        this.spoiler = spoiler;
    }
}
