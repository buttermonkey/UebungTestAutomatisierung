package org.campus02.test;

import org.campus02.BMIAnalyzer;
import org.campus02.Pair;
import org.campus02.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BMIAnalyzerTest {

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

    @Test
    void calcBmi() {
        BMIAnalyzer bmiAnalyzer = new BMIAnalyzer();
        assertEquals(80.0 / (1.8 * 1.8), bmiAnalyzer.calcBmi(person1), .001);
    }

    /**
     * check result
     */
    @Test
    void analyze() {
        BMIAnalyzer bmiAnalyzer = new BMIAnalyzer();
        bmiAnalyzer.setPersons(persons);
        bmiAnalyzer.analyze();

        ArrayList<Pair<Person, Double>> results = bmiAnalyzer.getResult();
        results.forEach(result -> {
            Person person = result.getKey();
            Double bmi = result.getValue();
            assertEquals(bmiAnalyzer.calcBmi(person), bmi, .001);
        });
    }
}