package LambdaExpressions_Exercices;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Part_1_Ex_1 {

    public static void main(String[] args) {

        List<String> cars = new ArrayList<>();
        cars.add("Audi A5");
        cars.add("Nisan GTR");
        cars.add("Porche 911");
        cars.add("BMW X6");
        cars.add("Ford Mustang GT");

        cars.sort(comparing(String::length));
        System.out.println("List sorted by strings length ascending: " + cars);

        //=================================================================================================
        cars.sort(comparing(String::length)
                .reversed());
        System.out.println("List sorted by strings length descending: " + cars);

        //=================================================================================================
        cars.sort((s1, s2) -> s1.charAt(0) - (s2.charAt(0)));
        System.out.println("List sorted by the first char from the string: " + cars);

        //=================================================================================================
//        cars.sort((str1, str2) -> {
//            if(str1.contains("e") && str2.contains("e")) {
//                return 0;
//            }
//            else if(str1.contains("e")) {
//                return -1;
//            }else {
//                return 1;
//            }
//        });

        cars.sort((str1, str2) -> {
            int compareFlag = 0;
            if(str1.contains("e") && !str2.contains("e")){
                compareFlag = -1;
            }
            else if(!str1.contains("e") && str2.contains("e")){
                compareFlag = 1;
            }
            return compareFlag;
        });

        System.out.println("List sorted using the criteria: if it contains 'e' it should be first, everything else second: " + cars);

        //=================================================================================================
        //***###***
        // cars.sort((s1, s2) -> Utils.customComparison(s1, s2));
        //Same functionality with method reference
        cars.sort(Utils::customComparison);
        System.out.println("List sorted using the previous condition but implemented in a separate static function frin a utility class: " + cars);

    }


}
