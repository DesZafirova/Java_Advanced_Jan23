package SetsAndMapsLab;

import java.util.*;


public class AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if(studentsMap.containsKey(name)){
                studentsMap.get(name).add(grade);
            }else{
                studentsMap.put(name,new ArrayList<>());
                studentsMap.get(name).add(grade);
            }
        }

        Map<String, Double> averageGradeStudents = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            //entry: (key)име на студента -> (value)списък с оценки
            String studentName = entry.getKey(); //име на студент
            List<Double> listGrades = entry.getValue(); //списък с оценки за всеки студент
            double averageGrade = getAverageGrade(listGrades);
            System.out.print(entry.getKey() + " -> ");
            for (Double e1 : entry.getValue()) {
                System.out.printf("%.2f ", e1);
            }
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }
    } private static double getAverageGrade(List<Double> listGrades) {
        double sum = 0;
        double average = 0;
        for (int i = 0; i < listGrades.size(); i++) {
            sum+= listGrades.get(i);
        }
        return average = sum/ listGrades.size();

    }
}



