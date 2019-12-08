package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

import java.time.OffsetDateTime;

public class TraktList
{
    private String name;
    private String description;
    private String privacy;
    private boolean display_numbers;
    private boolean allow_comments;
    private String sort_by;
    private String sort_how;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private int item_count;
    private int comment_count;
    private int likes;
    private Ids ids;
    private TraktUser user;
}
