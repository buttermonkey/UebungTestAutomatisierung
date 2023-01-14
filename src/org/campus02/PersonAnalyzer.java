package org.campus02;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonAnalyzer {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    // abstract erzwingt die Implementierung in den Subklassen
    public abstract void analyze();
}
