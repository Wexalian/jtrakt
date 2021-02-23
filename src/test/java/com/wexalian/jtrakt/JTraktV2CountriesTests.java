package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.countries.TraktCountry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("countries")
public class JTraktV2CountriesTests extends JTraktV2Tests {
    
    @Test
    public void testCountries() {
        List<TraktCountry> countries = TRAKT.getCountriesEndpoint().getCountries(TraktItemFilterType.SHOWS);
        
        Assertions.assertNotNull(countries, "countries are null");
        Assertions.assertTrue(countries.size() > 0, "countries size is 0");
    }
}
