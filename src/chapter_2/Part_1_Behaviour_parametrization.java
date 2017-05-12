package chapter_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Part_1_Behaviour_parametrization {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        Apple a1 = new Apple("green", 200);
        inventory.add(a1);
        Apple a2 = new Apple("green", 100);
        inventory.add(a2);
        Apple a3 = new Apple("red", 70);
        inventory.add(a3);
        Apple a4 = new Apple("green", 220);
        inventory.add(a4);
        Apple a5 = new Apple("red", 180);
        inventory.add(a5);
        Apple a6 = new Apple("red", 120);
        inventory.add(a6);

        List<Apple> redApples = filterList(inventory, (Apple a) -> "red".equals(a.getColor()));
        System.out.println("Red apples: ");
        printList(redApples);

        List<Apple> greenApples = filterList(inventory, a -> "green".equals(a.getColor()));
        System.out.println("Green apples: ");
        printList(greenApples);

        List<Apple> readAndHeavyApples = filterList(inventory, a -> "red".equals(a.getColor()) && a.getWeight() > 150);
        System.out.println("Apples that are red and heavy: ");
        printList(readAndHeavyApples);

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Sort apples based on weight: ");
        inventory.sort((Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        printList(inventory);

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Using a lamda expression in a thread:");
        Thread t = new Thread(() -> System.out.println("Lamda expression thread example"));
        t.start();

    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static <T> void printList(List<T> list){
        for(T t : list){
            System.out.println(t.toString());
        }
    }
}
