package SetsAndMapsLab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] parts = input.split(", ");
            String directions = parts[0];
            String number = parts[1];

            switch (directions){
                case "IN":
                    cars.add(number);
                    break;
                case "OUT":
                    cars.remove(number);
                    break;
            }
            input = scanner.nextLine();
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : cars){
                System.out.println(car);
            }
            //cars.forEach(car-> System.out.println(cars));
        }
    }
}
