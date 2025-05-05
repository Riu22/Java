package exceptions;
//el error es que la clase mutebird en el apartat de makeSound no tenia posat que pot generar una excepcio
public class ejercici13 {
    public static void main(String[] args) {
        Animal a;

         //a = new Dog();
         //a = new Cat();
        a = new MuteBird();

        try {
            a.makeSound();
        } catch (muteException e) {
            System.out.println("Aquest animal no pot fer cap so.");
        }
    }
}

class muteException extends Exception {
    public muteException() {
        super("L’animal és mut.");
    }
}

abstract class Animal {
    abstract void makeSound() throws muteException;
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

class MuteBird extends Animal {
    @Override
    void makeSound() throws muteException {
        throw new muteException();
    }
}