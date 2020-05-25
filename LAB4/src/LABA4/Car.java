package LABA4;
public class Car {
    private int speed;

    Car(){
        drive();
    }

    public int getSpeed(){
        return this.speed;
    }
    public void drive(){
        int min = 25;
        int max = 100;
        this.speed = (int) (Math.random()*((max-min)+1))+min;;
    }
}
