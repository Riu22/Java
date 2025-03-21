package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface volador{
    void volar();
}

abstract class animales {
    String nombre;
    int edad;
    abstract void hacerSonido();
    abstract void moverse();
    void imprimirInfor(){
        System.out.println("Nombre: " + this.nombre);
    }
}

class leon extends animales {

    leon(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    void hacerSonido() {
        System.out.printf("el leon ruge");
    }

    @Override
    void moverse() {
        System.out.printf("el leon se mueve");
    }
}

class elefante extends animales {
    elefante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;

    }
    @Override
    void hacerSonido() {
        System.out.printf("el elefante hace ruido");
    }

    void moverse(){
        System.out.printf("el elefante mueve");
    }
}

class aguilla extends animales implements volador{

    aguilla(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    void moverse() {
        System.out.printf("el aguila camina");

    }
    void hacerSonido(){
        System.out.printf("el aguilla hace ruido");
    }

     public void volar(){
        System.out.printf("el aguilla vuela");
    }
}
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<animales> animals = new ArrayList<animales>();
        animals.add(new leon("leon", 10));
        animals.add(new elefante("elefante", 20));
        animals.add(new aguilla("aguilla", 30));

        for (animales animal : animals) {
            animal.hacerSonido();
            animal.moverse();
            animal.imprimirInfor();
        }

        if( animals instanceof volador){
            ((volador)animals).volar();
        }
    }
}
