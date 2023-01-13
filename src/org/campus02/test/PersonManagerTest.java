package org.campus02.test;

import org.campus02.MaxSalaryAnalyzer;
import org.campus02.Person;
import org.campus02.PersonManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {

    Person person1;

    MaxSalaryAnalyzer maxSalaryAnalyzer;

    @BeforeEach
    void setUp() {
        person1 = new Person(
                "max",
                "mustermann",
                'W',
                22,
                "AUT",
                2000,
                "blau",
                80,
                180
        );

        maxSalaryAnalyzer = new MaxSalaryAnalyzer();
    }

    @Test
    void addPerson() {
        PersonManager personManager = new PersonManager();
        personManager.addPerson(person1);

        personManager.doAnalysis(maxSalaryAnalyzer);
        HashSet<Person> personsWithHighestSalary = maxSalaryAnalyzer.getPersonsWithHighestSalary();
        assertEquals(1, personsWithHighestSalary.size());
        assertTrue(personsWithHighestSalary.contains(person1));
    }
}