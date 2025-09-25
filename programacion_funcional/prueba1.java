package programacion_funcional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface MyFunction{
    int suma(int a, int b);
}

class city{
    String Nom;
    int poblacio;


    city(String Nom, int poblacio){
        this.Nom = Nom;
        this.poblacio = poblacio;
    }

    @Override
    public String toString() {
        return "city{" +
                "Nom='" + Nom + '\'' +
                ", poblacio=" + poblacio +
                '}';
    }
}
public class prueba1 {
    public static void main(String[] args){
        MyFunction f = (a,b) -> a+b;
        List<city> list = new ArrayList<>();
        list.add(new city("Palma",800));
        list.add(new city("Polonia",97676));
        list.add(new city("Amsterdam", 8977));
        list.add(new city("Japon", 7645));
        list.add(new city("Valencia",76634));
        list.sort((a,b) -> a.poblacio-b.poblacio);
        System.out.println(list);

        Stream<city> stream = list.stream();
        city firstcity = stream
                .filter(city -> city.poblacio > 10000)
                .findFirst()
                .get();
        System.out.println(firstcity);

        List<city> cities = stream
                .filter(city -> city.poblacio > 10000)
                .toList();
        System.out.println(cities);

        List<String> names=list.stream()
                .map(city -> city.Nom)
                .toList();
        System.out.println(names);

        int total =list.stream()
                .map(city -> city.poblacio)
                .reduce(0, (a, b) -> a + b);
        System.out.println(total);
    }
}
