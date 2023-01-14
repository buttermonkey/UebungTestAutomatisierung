package org.campus02.test;

import org.campus02.BMIAnalyzer;
import org.campus02.Pair;
import org.campus02.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMIAnalyzerTest {

	List<Person> people;
	Person bmiPerson;
	double expectedBmi;
	BMIAnalyzer bmiAnalyzer;

	@BeforeEach
	void setUp() {
		people = List.copyOf(TestDataProvider.people.values());
		bmiPerson = TestDataProvider.people.get("bmi");
		expectedBmi = TestDataProvider.BMI_WEIGHT / (TestDataProvider.BMI_HEIGHT * TestDataProvider.BMI_HEIGHT / 10000.0);
		bmiAnalyzer = new BMIAnalyzer();
	}

	@Test
	void calcBmi() {
		assertEquals(expectedBmi, bmiAnalyzer.calcBmi(bmiPerson), .001);
	}

	/**
	 * check result
	 */
	@Test
	void analyze() {
		bmiAnalyzer.setPersons(people);
		bmiAnalyzer.analyze();

		ArrayList<Pair<Person, Double>> results = bmiAnalyzer.getResult();
        Double actualBmi = results.stream()
                .filter(v -> v.getKey().equals(bmiPerson))
                .map(Pair::getValue)
                .findFirst()
                .orElseThrow();

        assertEquals(expectedBmi, actualBmi, .001);
	}
}