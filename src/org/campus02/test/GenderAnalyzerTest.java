package org.campus02.test;

import org.campus02.GenderAnalyzer;
import org.campus02.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenderAnalyzerTest {

    Person person1;
    Person person2;
    Person person3;

    ArrayList<Person> persons = new ArrayList<>();

    @BeforeEach
    void setUp() {
        person1 = new Person(
                "max",
                "mustermann",
                'M',
                22,
                "AUT",
                2000,
                "blau",
                80,
                180
        );

        person2 = new Person(
                "susi",
                "sorglos",
                'W',
                22,
                "AUT",
                4000,
                "gelb",
                60,
                160
        );

        person3 = new Person(
                "max",
                "mustermann",
                'M',
                22,
                "AUT",
                2000,
                "blau",
                80,
                200
        );

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
    }

    /**
     * Test the result of avgM and avgW
     */
    @Test
    void analyze() {
        GenderAnalyzer genderAnalyzer = new GenderAnalyzer();
        genderAnalyzer.setPersons(persons);
        genderAnalyzer.analyze();

        assertEquals(190, genderAnalyzer.getAvgM());
        assertEquals(160, genderAnalyzer.getAvgW());
    }
}