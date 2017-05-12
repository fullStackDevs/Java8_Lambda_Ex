package LambdaExpressions_Exercices_Part_2;

import LambdaExpressions_Exercices.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.UnaryOperator;

public class Part_2_Ex_3 {

    public static void main(String[] args) {

//1      method1(x, y, d -> Math.cos(d));
//2      someList.forEach(entry -> System.out.println(entry));
//3      method2(a, b, c, (d1,d2) -> Math.pow(d1,d2));
//4      someStream.reduce(0, (i1,i2) -> Integer.sum(i1, i2));
//5      method3(foo, bar, (a,b,c) -> Utils.doSomethingWith(a,b,c));
//6      method4(() -> Math.random());

        //================================================================
        //1)
        method1(98, 20, Math::cos);

        //================================================================
        //2)
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Audi A5", 310);
        cars.add(car1);
        Car car2 = new Car("BMW 320", 290);
        cars.add(car2);
        Car car3 = new Car("Nisan GTR", 390);
        cars.add(car3);
        Car car4 = new Car("Tesla M", 220);
        cars.add(car4);

        System.out.println("Cars: ");
        //The forEach method receives a Consumer parameter
        cars.forEach(System.out::println);

        //================================================================
        //3)
        method_ex_3(34.5, 20.3, 11.9, Math::pow);

        //================================================================
        //4)
        // Stream.reduce -
        int sumOfAllTheTopSpeads = cars.stream()
                .mapToInt(Car::getTopSpeed)
                .reduce(0, Integer::sum);
        System.out.println("Sum of the topSpead field from all the cars in the colection is: " + sumOfAllTheTopSpeads);

        //================================================================
        //5)
        //method_ex_5(2001, 240000, UtilsClass::doSomething);




    }



    public static double method1(double x, double y, UnaryOperator<Double> myFunction){
        if(x > 90){
            return myFunction.apply(x);
        }
        else{
            return myFunction.apply(y);
        }
    }

    public static double method_ex_3(double a, double b, double c, DoubleBinaryOperator function){
        double result = 0.0;
        if(a > b){
            result = function.applyAsDouble(a, b);
        }
        else if(b > c){
            result = function.applyAsDouble(b, c);
        }
        return result;
    }

//    public static int method_ex_5(int productionYear, int kmUsed, MyInterface myInterface){
//        if(productionYear < 2006){
//            return myInterface.computeRegistrationTax(1500, productionYear, kmUsed);
//        }
//        else{
//            return myIn
//        }
//
//    }
}
