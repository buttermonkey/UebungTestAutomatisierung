package org.campus02.stoff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {

    Person person;
    MockAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        person = new Person(
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

        analyzer = new MockAnalyzer();
    }

    @Test
    void addPerson() {
        PersonManager personManager = new PersonManager();
        personManager.addPerson(person);

        personManager.doAnalysis(analyzer);
        assertTrue(analyzer.wasAnalyzeCalled());
        assertTrue(analyzer.wasPersonAnalyzed(person));
    }

    private static class MockAnalyzer extends PersonAnalyzer {

        boolean analyzeWasCalled = false;
        Set<Person> analyzedPeople = new HashSet<>();

        @Override
        public void analyze() {
            analyzeWasCalled = true;
            analyzedPeople = Set.copyOf(this.getPersons());
        }

        public boolean wasAnalyzeCalled() {
            return analyzeWasCalled;
        }

        public boolean wasPersonAnalyzed(Person person) {
            return analyzedPeople.contains(person);
        }
    }
}