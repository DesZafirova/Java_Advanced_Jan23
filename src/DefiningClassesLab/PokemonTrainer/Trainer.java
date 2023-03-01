package PokemonTrainer;

import java.util.List;

public class Trainer {
    private String trainerName;
    private int countBadges;
    private List<Pokemon> pokemonList;

    public int getCountBadges() {
        return countBadges;
    }

    public Trainer(String trainerName, List<Pokemon> pokemonList) {
        this.trainerName = trainerName;
        this.countBadges = 0;
        this.pokemonList = pokemonList;
    }

    public void commandExecuting(String command) {
        if (isExist(command)) {
            countBadges++;
        } else {
            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if(pokemonList.get(i).getHealth() <=0){
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return trainerName + " " + countBadges + " " + pokemonList.size();
    }
}
