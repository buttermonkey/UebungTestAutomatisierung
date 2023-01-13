package org.campus02.test;

import org.campus02.MaxSalaryAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.campus02.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MaxSalaryAnalyzerTest {

    Person person1;
    Person person2;

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

        persons.add(person1);
        persons.add(person2);
    }
    /**
     * check personsWithHighestSalary
     */
    @Test
    void analyze() {
        MaxSalaryAnalyzer maxSalaryAnalyzer = new MaxSalaryAnalyzer();
        maxSalaryAnalyzer.setPersons(persons);
        maxSalaryAnalyzer.analyze();

        HashSet<Person> personsWithHighestSalary = maxSalaryAnalyzer.getPersonsWithHighestSalary();
        assertEquals(1, personsWithHighestSalary.size());
        assertTrue(personsWithHighestSalary.contains(person2));
        assertFalse(personsWithHighestSalary.contains(person1));
    }
}