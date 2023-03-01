package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(Company company, List<Pokemon> pokemon, List<Parents> parents, List<Children> children, Car car) {

        this.company = company;
        this.pokemons = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Pokemon> getPokemons(Pokemon pokemon) {
        return this.pokemons;
    }

    public List<Parents> getParents(Parents parents) {

        return this.parents;
    }

    public List<Children> getChildren(Children children) {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
        if (company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (car != null) {
            sb.append(car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        for(Pokemon pokemon:pokemons){
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        for(Parents parent:parents){
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for(Children child: children){
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
