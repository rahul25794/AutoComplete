package com.autocomplete.repository;

import java.util.List;

import com.autocomplete.generated.jooq.tables.pojos.Country;

import static com.autocomplete.generated.jooq.tables.Country.COUNTRY;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountriesRepository {
    private final DSLContext DB;

    @Autowired
    public CountriesRepository(DSLContext dsl) {
        this.DB = dsl;
    }
    //we can implement more complex search query but this simple query should be enough for now
    public List<Country> getSuggestions(String term, int limit) {
        return DB.select().from(COUNTRY).where(COUNTRY.NAME.startsWith(term)).limit(limit).fetchInto(Country.class);
    }

}