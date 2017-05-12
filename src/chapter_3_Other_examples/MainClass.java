package chapter_3_Other_examples;

import chapter_2.Apple;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.UnaryOperator;

import static java.util.Comparator.comparing;

public class MainClass {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        Apple a1 = new Apple("green", 120);
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

        System.out.println("//Same lambd multiple functional interfaces:");
        Comparator<Apple> appleWeightComparator = (a_1, a_2) -> a1.getWeight().compareTo(a2.getWeight());
        inventory.sort(appleWeightComparator);
        System.out.println("Inventory sorted with appleComparator:");

        ToIntBiFunction<Apple, Apple> appleComparatorToIntBiFunction = (ap1, ap2) -> ap1.getWeight().compareTo(ap1.getWeight());
        //***###***
        //Metoda 'sort' accepta doar Comparator nu si ToIntBiFunction sau BiFunction
        //inventory.sort(appleComparatorToIntBiFunction);

        BiFunction<Apple, Apple, Integer> appleComparator3 = (apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight());
        //***###***
        //Nu merge sa fac sort cu o expresie lambda care are target function BiFunction
        //inventory.sort(appleComparator3);

        System.out.println("===============================================================================");
        System.out.println("Method references");
        System.out.println("-------------------");

        //Comparator using method reference:
        System.out.println("Inventroy sorted by color: ");
        inventory.sort(comparing(Apple::getColor));
        System.out.println(inventory);

        System.out.println("================================================================================");
        System.out.println("CHAINING COMPARATORS");
        System.out.println("Inbentory sorted by weight in descending order and if the weights of 2 apples are the same we use the color as a second sorting criteria:");
        inventory.sort(comparing(Apple::getWeight)
                         .reversed()
                         .thenComparing(Apple::getColor)
        );
        System.out.println(inventory);


        System.out.println("================================================================================");
        System.out.println("COMPOSING FUNCTIONS");
        System.out.println("f(x) = x -> x + 1");
        System.out.println("g(x) = x -> x * 2");
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);

        System.out.println("f.andThen(g) --- g(f(x)) where x = 1");
        System.out.println(h.apply(1));

        System.out.println("f.compose(g) --- f(g(x)) where x = 1");
        Function<Integer, Integer> r = f.compose(g);
        System.out.println(r.apply(1));





    }


}
