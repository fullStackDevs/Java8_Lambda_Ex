package LambdaExpressions_Exercices;

public class Utils {

    public static int customComparison(String s1, String s2){
        int compareFlag = 0;
        if(s1.contains("e") && !s2.contains("e")){
            compareFlag = -1;
        }
        else if(!s1.contains("e") && s2.contains("e")){
            compareFlag = 1;
        }
        return compareFlag;
    }
}
