package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("languages")
public class JTraktV2LanguagesTests extends JTraktV2Tests {
    
    @Test
    public void testLanguages() {
        List<TraktLanguage> languages = TEST_TRAKT.getLanguagesEndpoint().getLanguages(TraktItemFilterType.SHOWS);
        
        Assertions.assertNotNull(languages, "languages are null");
        Assertions.assertTrue(languages.size() > 0, "languages size is 0");
    }
}
