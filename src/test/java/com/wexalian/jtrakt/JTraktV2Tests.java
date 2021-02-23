package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

public class JTraktV2Tests {
    public static final boolean STAGING = true;
    protected static final String STAGING_TAG = STAGING ? "staging" : "not_staging";
    protected static final JTraktV2 TRAKT = getTrakt();
    protected static final int LIST_ID = getListId();
    protected static final TraktMovie MOVIE = getMovie();
    protected static final TraktShow SHOW = getShow();
    protected static final TraktEpisode EPISODE = getEpisode();
    protected static final TraktAccessToken ACCESS_TOKEN = getAccessToken();
    
    private static int getListId() {
        return 86; // only available list id (in range 1-1500) on staging
        // return STAGING ? 86 : 1248149; //random lists I chose
    }
    
    private static TraktAccessToken getAccessToken() {
        if (STAGING) {
            return new TraktAccessToken("20bc5b45c4e4cd67e7ea9d1971817befb3a16588f21dc829b848ddabb731bbc3", "8c20fad50d26c41965265741aeafa06324175e3fe27ea8badb5cd9672964db59", 1613412450);
        }
        return new TraktAccessToken("a066b5d1cd74145a8175d278019b7aa76180ecba498fdd0ba57726f5717696be", "599c6f9dad982006fe29eb82972abcf514a4bb7cd237a0de7f4d9a3c994d3edd", 1613429990);
    }
    
    private static JTraktV2 getTrakt() {
        if (STAGING) {
            return new JTraktV2("48a2b34a26e246786c24b4fcd87be469b3f4f6df521b56cefddaf17b4223e1ed", "6e6eaa638ee1f0e731506823146347ec09413f024901f1da37329f89285b6ce4", true);
        }
        return new JTraktV2("3281b4c31326c24994ba55d28577fae5288c2cbbc1260ae2af7268da9bc413b5", "069524dcc74072a78db8b6f74460c5eb0c3f29e33d6d135250658978f07e68eb", false);
    }
    
    private static TraktMovie getMovie() {
        return new TraktMovie("Iron Man", 2005, TraktIds.slug("iron-man-2008"));
    }
    
    private static TraktShow getShow() {
        return new TraktShow("Arrow", 2012, TraktIds.imdb("tt2193021"));
    }
    
    private static TraktEpisode getEpisode() {
        return new TraktEpisode(1, 1, "Days Gone Bye", TraktIds.imdb("tt1589921"));
    }
}
