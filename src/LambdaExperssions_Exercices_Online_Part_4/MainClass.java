package LambdaExperssions_Exercices_Online_Part_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

        String s1 = words.stream()
                         .filter(word -> word.length() > 5)
                         .findFirst()
                         .orElse(null);
        System.out.println("The string s1 has the value: " + s1);

        String s2 = words.stream()
                         .filter(word -> word.contains("o"))
                         .findFirst()
                         .orElse(null);

        System.out.println("The string s2 has the value: " + s2);

        //========================================================================
        System.out.println("The first word that have the letter 'e' AND less than 5 carachters: " + firstAllMatch(words.stream(), word -> word.contains("e"), word -> word.length() < 5));
        System.out.println("The first word that contain the letter 'o' OR have more than 4 letters: " + firstAnyMatch(words.stream(), word -> word.contains("o"), word -> word.length() > 4));


    }

    public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates){
        Predicate<T> finalPredicate = (t) -> true;
        for(Predicate<T> pred : predicates){
            finalPredicate = finalPredicate.and(pred);
        }
        return finalPredicate;
    }

    public static <T> T firstAllMatch(Stream<T> streamOfElem, Predicate<T>... predicates){
        return streamOfElem
                .filter(allPassPredicate(predicates))
                .findFirst()
                .orElse(null);
    }

    public static <T> Predicate<T> anyPassPredicate(Predicate<T>... predicates){
        Predicate<T> combinedPredicates = (T) -> false;
        for(Predicate<T> predicate : predicates){
            combinedPredicates = combinedPredicates.or(predicate);
        }
        return combinedPredicates;
    }

    public static <T> T firstAnyMatch(Stream<T> streamOfElem, Predicate<T>... predicates){
        return streamOfElem
                .filter(anyPassPredicate(predicates))
                .findFirst()
                .orElse(null);
    }
}
