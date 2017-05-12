package LambdaExpressions_Exercices;

public class ElementUtils{

    public static <T> T betterEntry(T elem1, T elem2, TwoElementsPredicate<T> twoElementsPredicate){
        if(twoElementsPredicate.test(elem1, elem2)){
            return elem1;
        }
        else{
            return elem2;
        }
    }
}



