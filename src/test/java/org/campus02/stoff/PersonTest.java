package org.campus02.stoff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person(
                "max",
                "mustermann",
                'M',
                77,
                "AUT",
                1000,
                "blau",
                80,
                170
        );
    }

    @Test
    void testConstructor() {
        assertEquals("max", person.getFirstname());
        assertEquals("mustermann", person.getLastname());
        assertEquals('M', person.getGender());
        assertEquals("AUT", person.getCountry());
        assertEquals(1000, person.getSalary());
        assertEquals("blau", person.getEyeColor());
        assertEquals(80, person.getWeight());
        assertEquals(170, person.getSize());
    }

    @Test
    void setEyeColor() {
        person.setEyeColor("grün");
        assertEquals("grün", person.getEyeColor());
    }
}