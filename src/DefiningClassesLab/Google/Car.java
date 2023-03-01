package Google;

public class Car {
    private String carModel;
    private int carPower;

    public Car(String carModel, int carPower) {
        this.carModel = carModel;
        this.carPower = carPower;
    }
    @Override
    public String toString(){
        return String.format("%s %s", this.carModel,this.carPower);
    }

}
