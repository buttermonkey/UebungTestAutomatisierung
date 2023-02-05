package org.campus02.stoff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MaxSalaryAnalyzerTest {

    List<Person> people;

    @BeforeEach
    void setUp() {
        people = List.copyOf(TestDataProvider.people.values());
    }

    /**
     * check personsWithHighestSalary
     */
    @Test
    void analyze() {
        MaxSalaryAnalyzer maxSalaryAnalyzer = new MaxSalaryAnalyzer();
        maxSalaryAnalyzer.setPersons(people);
        maxSalaryAnalyzer.analyze();

        Set<Person> personsWithHighestSalary = maxSalaryAnalyzer.getPersonsWithHighestSalary();
        assertEquals(1, personsWithHighestSalary.size());
        assertTrue(personsWithHighestSalary.contains(TestDataProvider.people.get("max-salary")));
        assertFalse(personsWithHighestSalary.contains(TestDataProvider.people.get("not-max-salary")));
    }
}