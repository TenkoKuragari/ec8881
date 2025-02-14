package jcf;

import java.util.*;

public class PokemonStadium {
    private Pokemon charmander;
    private Pokemon squirtle;
    private Pokemon starly;
    private Pokemon diglett;
    private Pokemon hoothoot;
    private Pokemon magikarp;
    private List<Pokemon> pokemonList;

    public PokemonStadium() {
        pokemonList = new ArrayList<>();
        this.charmander = new Pokemon("Charmander", 4, Pokemon.Type.FIRE);
        this.starly = new Pokemon("Starly", 396, Pokemon.Type.FLYING);
        this.hoothoot = new Pokemon("Hoothoot", 163, Pokemon.Type.FLYING);
        this.diglett = new Pokemon("Digglet", 150, Pokemon.Type.GROUND);
        this.magikarp = new Pokemon("Magikarp", 129, Pokemon.Type.WATER);
        this.squirtle = new Pokemon("Squirtle", 7, Pokemon.Type.WATER);

        pokemonList.addAll(Arrays.asList(charmander, starly, hoothoot, diglett, magikarp));

    }

    public static void main(String[] args) {
        PokemonStadium stadium = new PokemonStadium();
        stadium.findPokemon();
        stadium.orderPokemons();
        stadium.orderSpecialPokemons();
        stadium.findPokemonFast();
    }

    private void findPokemon() {
        System.out.println("Finding a pokemon .....");
        System.out.println("Is hoothoot here? " + pokemonList.contains(this.hoothoot));

        System.out.println("Is charmander here? " + pokemonList.contains(
                new Pokemon("Charmander", 4, Pokemon.Type.FIRE)
        ));
    }

    private void orderedStrings() {
        Set<String> strings = new TreeSet<>();
        strings.add("c");
        strings.add("a");
        strings.add("l");
        strings.add("b");
        strings.add("d");

        for (String s : strings) {
            System.out.println(s);
        }
    }

    private void orderPokemons() {
        System.out.println("Printing the pokemons in order");
        Set<Pokemon> pokemonSet = new TreeSet<>(this.pokemonList);
        for (Pokemon p : pokemonSet) {
            System.out.println(p);
        }
    }

    private void orderSpecialPokemons() {
        System.out.println("Printing the pokemons in a special order");
        Set<Pokemon> pokemonSet = new TreeSet<>(new PokemonComparator());
        pokemonSet.addAll(pokemonList);
        for (Pokemon p : pokemonSet) {
            System.out.println(p);
        }
    }

    private void findPokemonFast() {
        System.out.println("Finding pokemon in O(1) time");
        Map<Pokemon, Double> pokemonDoubleMap = new HashMap<>();
        pokemonDoubleMap.put(this.charmander, 19.8);
        pokemonDoubleMap.put(this.diglett, 1.8);
        pokemonDoubleMap.put(this.hoothoot, 16.8);
        pokemonDoubleMap.put(this.magikarp, 22.5);
        pokemonDoubleMap.put(this.squirtle, 10.2);
        pokemonDoubleMap.put(this.starly, 20.5);

        pokemonDoubleMap.put(new Pokemon("Hoothoot", 163, Pokemon.Type.FLYING), 25.0);

        for (Pokemon p : pokemonDoubleMap.keySet()) {
            System.out.println(p.getName() + "--" + pokemonDoubleMap.get(p));
        }
    }
}
