package LABA4;
public class CarRun implements Runnable{
    private Car car;

    CarRun(Car car){
        this.car = car;
    }
    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
        if (car.getSpeed() <= 60) {
            try {
                Thread.sleep(1000);
                Thread.currentThread().interrupt();
            } catch (InterruptedException ex) {
                System.err.println("An InterruptedException was caught: " + ex.getMessage());
                Thread.currentThread().interrupt();
            }
        }

    }
}
