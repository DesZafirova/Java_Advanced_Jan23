package Car_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsCollection = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] currentCar = scanner.nextLine().split(" ");
            String brand = currentCar[0];
            String model = currentCar[1];
            int horsePower = Integer.parseInt(currentCar[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);
            carsCollection.add(car);
        }
        carsCollection.forEach(car -> System.out.println(car.carInfo()));

    }
}
