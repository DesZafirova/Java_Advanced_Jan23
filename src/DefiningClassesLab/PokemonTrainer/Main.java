package PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        while (!inputLine.equals("Tournament")) {
            String[] input = inputLine.split("\\s+");
            String trainerName = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            if (!pokemonByTrainers.containsKey(trainerName)) {
                pokemonByTrainers.put(trainerName, new ArrayList<>());
            }
            pokemonByTrainers.get(trainerName).add(pokemon);

            inputLine = scanner.nextLine();
        }
        List<Trainer> trainerList = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());


        String power = scanner.nextLine();
        while (!power.equals("End")) {
           for (Trainer trainer: trainerList){
               trainer.commandExecuting(power);
           }

            power = scanner.nextLine();
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getCountBadges)
                        .reversed()).forEach(System.out::println);
    }
}
