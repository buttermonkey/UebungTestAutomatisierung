package org.campus02.stoff;

import java.util.HashMap;
import java.util.Map;

public class TestDataProvider {
	static final Map<String, Person> people = new HashMap<>();

	static final int BMI_WEIGHT = 80;
	static final int BMI_HEIGHT = 180;

	static final int MALE_HEIGHT_1 = BMI_HEIGHT;
	static final int MALE_HEIGHT_2 = 200;
	static final int FEMALE_HEIGHT_1 = 160;

	static final String COUNTRY_1 = "AUT";
	static final String COUNTRY_2 = "GER";

	static {
		people.put("max-mustermann", new Person(
				"max",
				"mustermann",
				'M',
				22,
				COUNTRY_1,
				2000,
				"blau",
				BMI_WEIGHT,
				BMI_HEIGHT
		));

		people.put("susi-sorglos", new Person(
				"susi",
				"sorglos",
				'W',
				22,
				COUNTRY_2,
				4000,
				"gelb",
				60,
				FEMALE_HEIGHT_1
		));

		people.put("tom-turbo", new Person(
				"tom",
				"turbo",
				'M',
				22,
				"AUT",
				2000,
				"blau",
				80,
				MALE_HEIGHT_2
		));

		people.put("bmi", people.get("max-mustermann"));
		people.put("max-salary", people.get("susi-sorglos"));
		people.put("not-max-salary", people.get("max-mustermann"));
		people.put("male-1", people.get("max-mustermann"));
		people.put("male-2", people.get("tom-turbo"));
		people.put("female-1", people.get("susi-sorglos"));
		people.put("country-1", people.get("max-mustermann"));
		people.put("country-2", people.get("susi-sorglos"));
	}
}
