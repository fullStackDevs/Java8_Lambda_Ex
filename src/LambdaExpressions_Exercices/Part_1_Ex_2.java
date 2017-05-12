package LambdaExpressions_Exercices;

public class Part_1_Ex_2 {

    public static void main(String[] args) {
        String str1 = "Keyboard";
        String str2 = "Laptop";


        String betterString = ElementUtils.betterEntry(str1, str2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("//The better string is the longest one");
        System.out.println("Between the stings: '" + str1 + "' and '" + str2 + "' the better one is: " + betterString);

        System.out.println("//The better string is the first one always");
        betterString = ElementUtils.betterEntry("car", "building", (s1, s2) -> true);
        System.out.println("Between the strings 'car' and 'building' the better one is: " + betterString);

        System.out.println("//The better car: ");
        Car car1 = new Car("Audi A5", 310);
        Car car2 = new Car("BMW 320", 290);
        Car betterCar = ElementUtils.betterEntry(car1, car2, (c1, c2) -> c1.getTopSpeed() > c2.getTopSpeed());
        System.out.println("The better car between Audi A5 and BMW 320 is " + betterCar);


    }
}
