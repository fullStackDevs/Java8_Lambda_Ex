package LambdaExpressions_Exercices;

public class Car {

    private String mark;
    private int topSpeed;

    public Car(String mark, int topSpeed){
        this.mark = mark;
        this.topSpeed = topSpeed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
