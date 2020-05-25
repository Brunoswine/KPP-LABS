package LABA4;
import java.util.ArrayList;

public class Road {
    private int lines = 5;
    private int countOfCheating;
    private int countOfCars;
    private int MaxSpeed;
    private ArrayList<Car> cars;
    private ArrayList<Thread> carsThreads;

    Road(){
        cars = new ArrayList<Car>(51);
        carsThreads = new ArrayList<Thread>(51);
        initCountOfCheating();
    }

    public void addCar(Car newCar){
        cars.add(newCar);
        carsThreads.add(new Thread(new CarRun(newCar)));
        carsThreads.get(carsThreads.size()-1).start();
        if(newCar.getSpeed() > 60) {
            this.countOfCheating++;
            if (newCar.getSpeed() > MaxSpeed) MaxSpeed = newCar.getSpeed();
            carsThreads.get(carsThreads.size()-1).interrupt();
            cars.remove(cars.size()-1);
            carsThreads.remove(carsThreads.size()-1);
        }
        this.countOfCars++;
    }

    public void initCountOfCheating(){
        this.countOfCheating = 0;
        this.countOfCars = 0;
        this.MaxSpeed = 0;
    }

    public int retAmount(){
        return this.countOfCars;
    }

    public void tellAboutCheating(){
        System.out.println("Кол-во нарушений: "+ this.countOfCheating);
        System.out.println("Макс скорость: "+ this.MaxSpeed);
        carsThreads.removeAll(carsThreads);
        cars.removeAll(cars);
    }

    public void checkCars(){
        for(int i = 0;i<this.carsThreads.size();i++){
            if(!this.carsThreads.get(i).isAlive()){
                this.cars.remove(i);
                this.carsThreads.remove(i);
            }
        }
    }
}
