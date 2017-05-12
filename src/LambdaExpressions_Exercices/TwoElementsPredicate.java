package LambdaExpressions_Exercices;

@FunctionalInterface
public interface TwoElementsPredicate<T> {

    boolean test(T elem1, T elem2);

    //void testFunction(T elem);
}



