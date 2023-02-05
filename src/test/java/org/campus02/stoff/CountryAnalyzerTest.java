package org.campus02.stoff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountryAnalyzerTest {

    List<Person> people = new ArrayList<>();

    @BeforeEach
    void setUp() {
        people.add(TestDataProvider.people.get("country-1"));
        people.add(TestDataProvider.people.get("country-1"));
        people.add(TestDataProvider.people.get("country-1"));
        people.add(TestDataProvider.people.get("country-2"));
    }

    /**
     * check result
     */
    @Test
    void analyze() {
        CountryAnalyzer countryAnalyzer = new CountryAnalyzer();
        countryAnalyzer.setPersons(people);
        countryAnalyzer.analyze();

        Map<String, Integer> result = countryAnalyzer.getResult();

        assertEquals(2, result.size());
        assertTrue(result.containsKey(TestDataProvider.COUNTRY_1));
        assertTrue(result.containsKey(TestDataProvider.COUNTRY_2));
        assertEquals(3, result.get(TestDataProvider.COUNTRY_1));
        assertEquals(1, result.get(TestDataProvider.COUNTRY_2));
    }
}