package org.campus02;

import java.util.HashMap;

public class CountryAnalyzer extends PersonAnalyzer {
    // key = Land
    // value = Anzahl der Person in diesem Land
    private HashMap<String, Integer> result = new HashMap<>();

    public HashMap<String, Integer> getResult() {
        return result;
    }

    @Override
    public void analyze() {
        // iter + Tab => iteration erstellen lassen
        for (Person person : super.getPersons()) {
            String country = person.getCountry();
            if (result.containsKey(country)) {
                result.put(country, result.get(country) + 1);
            } else {
                result.put(country, 1);
            }
        }
    }
}
