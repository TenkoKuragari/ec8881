package inheritance;

/**
 * Simple class for testing the creation of Monsters and simulating
 * a fight between two monsters.
 *
 * @author CS RIT
 */
public class TestMonsters {

    public static void main(String[] args) {
        Monster mike = new Monster("Mike", 20);
        Monster sully = new Monster("Sully", 50);
        Phoenix fawkes = new Phoenix("Fawkes", 80);
        System.out.println(mike);
        System.out.println(sully);
        System.out.println(fawkes);

        Monster m = fawkes;
        m.takeDamage(15);
        fawkes.fly(30);


        mike.takeDamage(10);
        sully.takeDamage(25);

        System.out.println(mike);
        System.out.println(sully);

        mike.takeDamage(15);
        System.out.println(mike);
    }
}


