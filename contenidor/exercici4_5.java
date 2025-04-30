package contenidor;

import java.util.*;

class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class exercici4_5 {
    public static void main(String[] args) {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Spain"));
        countryList.add(new Country("France"));
        countryList.add(new Country("Germany"));
        countryList.add(new Country("Italy"));
        countryList.add(new Country("Portugal"));

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(countryList);
            System.out.println("Shuffle " + (i + 1) + ": " + countryList);
        }

        //descomentar siguiente lista para saber si da error como explica en el ejercicio5
        // countryList.add("Not a country");
    }
}

