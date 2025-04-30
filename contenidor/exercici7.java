package contenidor;
import java.util.*;

class Animal {}

class Dog extends Animal {
    String name;
    Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +  name + "'}";
    }
}

class Cat extends Animal {
    String name;
    Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{"  + name + "'}";
    }
}

public class exercici7 {
    public static void main(String[] args) {
        List<Animal> lista = new ArrayList<>();
        lista.add(new Dog("Bob"));
        lista.add(new Cat("Bab"));
        lista.add(new Dog("Max"));
        lista.add(new Cat("Mia"));

        for (Animal a : lista) {
            if (a instanceof Dog) {
                System.out.println("This is a Dog: " + a);
            } else if (a instanceof Cat) {
                System.out.println("This is a Cat: " + a);
            }
        }
    }
}
