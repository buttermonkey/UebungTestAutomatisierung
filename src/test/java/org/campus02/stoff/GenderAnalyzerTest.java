package org.campus02.stoff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenderAnalyzerTest {

    ArrayList<Person> persons = new ArrayList<>();

    @BeforeEach
    void setUp() {
        persons.add(TestDataProvider.people.get("male-1"));
        persons.add(TestDataProvider.people.get("male-2"));
        persons.add(TestDataProvider.people.get("female-1"));
    }

    /**
     * Test the result of avgM and avgW
     */
    @Test
    void analyze() {
        final int expectedMaleAverage = (TestDataProvider.MALE_HEIGHT_1 + TestDataProvider.MALE_HEIGHT_2) / 2;
        final int expectedFemaleAverage = TestDataProvider.FEMALE_HEIGHT_1;

        GenderAnalyzer genderAnalyzer = new GenderAnalyzer();
        genderAnalyzer.setPersons(persons);
        genderAnalyzer.analyze();

        assertEquals(expectedMaleAverage, genderAnalyzer.getAvgM());
        assertEquals(expectedFemaleAverage, genderAnalyzer.getAvgW());
    }
}