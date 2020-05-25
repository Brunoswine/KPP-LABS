package LABA4;
public class main {
    public static void main(String[] args) {
        Road road = new Road();
        while(true) {
            road.addCar(new Car());
            road.checkCars();
            if(road.retAmount() == 50) {
                road.tellAboutCheating();
                road.initCountOfCheating();
            }
        }
    }


}