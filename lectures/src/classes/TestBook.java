package classes;

public class TestBook {
    public static void main(String[] args) {
        Book dune = new Book("Dune", 700, true);
        Book dracula = new Book("Dracula", 500, true);

        Book dracula2 = new Book("Dracula", 500, true);

        System.out.println("Are they the same? " + (dracula == dracula2));
        System.out.println("Are they the same? " + (dracula.equals(dracula2)));
    }
}