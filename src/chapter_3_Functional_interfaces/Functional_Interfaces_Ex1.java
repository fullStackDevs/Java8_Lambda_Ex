package chapter_3_Functional_interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Functional_Interfaces_Ex1 {

    public static void main(String[] args){

        List<String> strings = Arrays.asList("Java", "Lambda", "Comparator", "Interface");

        System.out.println("=====================================================================");
        System.out.println("//Predicate functional interface test:");
        Predicate<String> longWord = str -> str.length() > 8;
        System.out.println("List of long strings: " + filter(strings, longWord));

        System.out.println("=====================================================================");
        System.out.println("//Consumer functional interface test:");
        System.out.println("The sizes of the strings from the list are: ");
        forEach(strings, str -> System.out.println(str.length()));

        System.out.println("=====================================================================");
        System.out.println("Function functional interface test: ");
        System.out.println("Strings mapped to lengths: ");
        List<Integer> stringsLengths = map(strings, str -> str.length());
        System.out.println(stringsLengths);

        System.out.println("=====================================================================");
        System.out.println("#####################################################################");
        System.out.println("IntPredicat example:");
        IntPredicate evenNumber = nr -> nr % 2 == 0;
        System.out.println("Test if 1000 is an even number: ");
        System.out.println(evenNumber.test(1000));

        System.out.println("======================================================================");
        System.out.println("DoubleConsumer example: ");
        DoubleConsumer doubleConsumer = doubleNr -> System.out.println("It was passed the number: " + doubleNr);
        doubleConsumer.accept(23.54);

        System.out.println("======================================================================");
        System.out.println("IntFunction<R> example: ");
        IntFunction<Integer> timesTwo = intValue -> intValue * 2;
        System.out.println("The double value of 2643 is: " + timesTwo.apply(2643));

        System.out.println("======================================================================");
        System.out.println("IntToDoubleFunction example: ");
        IntToDoubleFunction half = intVal -> intVal * 0.5;
        System.out.println("Half of 5001 is: " + half.applyAsDouble(5001));

        System.out.println("======================================================================");
        System.out.println("ToIntFunction<T> example: ");
        ToLongFunction<Double> roundValue = doubleVale -> Math.round(doubleVale);
        System.out.println("The rounded value of 3.14 is: " + roundValue.applyAsLong(3.14));

        System.out.println("######################################################################");
        System.out.println("======================================================================");
        System.out.println("IntSupplier example: ");
        IntSupplier getAnInt = () -> 10;
        System.out.println("The int received from the supplier function is: "+ getAnInt.getAsInt());

        System.out.println("======================================================================");
        System.out.println("BooleanSupplier example: () -> boolean");
        BooleanSupplier myBooleanSupplier = () -> true;
        System.out.println("Boolean reveived from the myBooleanSupplier = " + myBooleanSupplier.getAsBoolean());


        System.out.println("======================================================================");
        System.out.println("UnaryOperator<T>  ---  T -> T");
        System.out.println("IntUnaryOperator example: (int) -> int ");
        IntUnaryOperator addTen = val -> val + 10;
        System.out.println("320 + 10 = " + addTen.applyAsInt(320));

        System.out.println("DoubleUnaryOperator....");
        System.out.println("LongUnaryOperator....");


        System.out.println("======================================================================");
        System.out.println("IntBinaryOperator example: (int, int) -> int ");
        IntBinaryOperator sumValues = (val1, val2) -> val1 + val2;
        System.out.println("The sum of the values 21 and 291 is: " + sumValues.applyAsInt(21, 291));

        System.out.println("LongBinaryOperator example: (long, long) -> long ");
        System.out.println("DoubleBinaryOperator example: (double, double) -> double ");


        System.out.println("======================================================================");
        System.out.println("######################################################################");
        System.out.println("BiPredicate<L, R>  ---  (L,R) -> boolean");
        BiPredicate<String, Integer> lettersInString = (str, nr) -> str.length() == nr;
        System.out.println("Does the string 'car' have 4 letters: " + lettersInString.test("car", 4));


        System.out.println("======================================================================");
        System.out.println("BiConsumer<T, U>  ---  (T,U) -> void");
        BiConsumer<String, Integer> consumeNameAndAge = (name, age) -> System.out.println(name + ", age: " + age);
        consumeNameAndAge.accept("Mihai", 32);


        System.out.println("======================================================================");
        System.out.println("BiFunction<T, U, R>  ---  (T,U) -> R");
        BiFunction<String, Integer, Person> createPerson = (name, age) -> new Person(name, age);
        System.out.println("New person created with the name Aaron and the age 33: " + createPerson.apply("Aaron", 33));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void forEach(List<String> list, Consumer<String> consumer){
        for(String str : list){
            consumer.accept(str);
        }
    }

    public static List<Integer> map(List<String> list, Function<String, Integer> function){
        List<Integer> result = new ArrayList<>();
        for(String str : list){
            result.add(function.apply(str));
        }
        return result;
    }


}
