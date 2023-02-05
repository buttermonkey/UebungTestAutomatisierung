package org.campus02.stoff;

import java.util.ArrayList;

public class BMIAnalyzer extends PersonAnalyzer {
    private ArrayList<Pair<Person, Double>> result = new ArrayList<>();

    public ArrayList<Pair<Person, Double>> getResult() {
        return result;
    }

    public double calcBmi(Person person) {
        return person.getWeight() / ((person.getSize() / 10.0) * (person.getSize() / 1000.0));
    }

    @Override
    public void analyze() {
        for (Person person : super.getPersons()) {
            double bmi = calcBmi(person);
            Pair<Person, Double> bmiPair = new Pair<>(person, bmi);
            result.add(bmiPair);
        }
    }
}
