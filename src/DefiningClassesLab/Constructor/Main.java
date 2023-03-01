package Constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsCollection = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carParts = scanner.nextLine().split(" ");
            String brand = carParts[0];
            Car car;
            if(carParts.length == 1){
                car = new Car(brand);
            }else {
                String model = carParts[1];
                int horsePower = Integer.parseInt(carParts[2]);
                car = new Car(brand, model, horsePower);
            }
            carsCollection.add(car);
        }
        carsCollection.forEach(car -> System.out.println(car.carInfo()));
    }
}
