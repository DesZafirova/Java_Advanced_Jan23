package CompanyRoster;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departments = new HashMap<>();
        double bestSalary = 0;
        for (int i = 0; i < n; i++) {
            String[] currentEmployee = scanner.nextLine().split("\\s+");

            String name = currentEmployee[0];
            double salary = Double.parseDouble(currentEmployee[1]);
            String position = currentEmployee[2];
            String department = currentEmployee[3];
            String email = "";
            int age = 0;
            Employee employee = null;
            if (currentEmployee.length == 6) {
                email = currentEmployee[4];
                age = Integer.parseInt(currentEmployee[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (currentEmployee.length == 5) {
                if (Character.isDigit(currentEmployee[4].charAt(0))) {
                    age = Integer.parseInt(currentEmployee[4]);
                    employee = new Employee(name, salary, position, department, age);

                } else {
                    email = currentEmployee[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (currentEmployee.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            if (departments.containsKey(department)) {
                departments.get(department).add(employee);
            } else {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            }


        }
        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get().getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);
        for(Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }

    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0;

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
