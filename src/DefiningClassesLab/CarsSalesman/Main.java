package CarsSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);

            int displacement = 0;
            String efficiency = null;
            if (data.length == 4) {
                displacement = Integer.parseInt(data[2]);
                efficiency = data[3];
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    displacement = Integer.parseInt(data[2]);
                } else {
                    efficiency = data[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            String engineModel = data[1];
            int weight = 0;
            String color = null;

            if (data.length == 4) {
                weight = Integer.parseInt(data[2]);
                color = data[3];
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    weight = Integer.parseInt(data[2]);
                } else {
                    color = data[2];
                }
            }
            Engine neededEngine = null;
            for (Engine e : engines) {
                if (engineModel.equals(e.getModel())) {
                    neededEngine = e;
                    break;
                }
            }
            Car car = new Car(carModel,neededEngine,weight, color);
            System.out.print(car.toString());
        }


    }

}

