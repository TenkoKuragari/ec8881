package jcf;

public class Pokemon implements Comparable<Pokemon> {

    @Override
    public int compareTo(Pokemon o) {
        return this.pokedex - o.pokedex;
    }

    public enum Type {GROUND, WATER, FIRE, FLYING}

    private final String name;
    private final int pokedex;
    private final Type type;

    public Pokemon(String name, int pokedex, Type type) {
        this.name = name;
        this.pokedex = pokedex;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getPokedex() {
        return pokedex;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pokemon) {
            Pokemon other = (Pokemon) o;
            return other.name.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", pokedex=" + pokedex +
                ", type=" + type +
                '}';
    }
}
