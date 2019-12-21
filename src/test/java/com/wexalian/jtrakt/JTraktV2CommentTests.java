package com.wexalian.jtrakt;

import com.wexalian.jtrakt.media.comment.TraktCommentLike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JTraktV2CommentTests extends JTraktV2Tests
{
    @Test
    public void testLikes()
    {
        List<TraktCommentLike> likes = TRAKT.getComments()
                                            .getLikes(417, null);
        
        Assertions.assertNotNull(likes);
    }
}
