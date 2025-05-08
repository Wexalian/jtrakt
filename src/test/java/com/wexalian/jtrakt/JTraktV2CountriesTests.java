package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.countries.TraktCountry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("countries")
public class JTraktV2CountriesTests extends JTraktV2Tests {
    
    @Test
    public void testCountries() {
        List<TraktCountry> countries = TRAKT.getCountriesEndpoint().getCountries(TraktItemsType.SHOWS);
        
        notNull(countries, "countries are null");
        Assertions.assertFalse(countries.isEmpty(), "countries size is 0");
    }
}
