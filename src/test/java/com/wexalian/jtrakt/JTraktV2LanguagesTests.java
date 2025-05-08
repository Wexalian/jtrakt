package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("languages")
public class JTraktV2LanguagesTests extends JTraktV2Tests {
    
    @Test
    public void testLanguages() {
        List<TraktLanguage> languages = TRAKT.getLanguagesEndpoint().getLanguages(TraktItemsType.SHOWS);
        
        notNull(languages, "languages are null");
        Assertions.assertFalse(languages.isEmpty(), "languages size is 0");
    }
}
