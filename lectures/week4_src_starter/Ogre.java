package inheritance;

/**
 * Simple Ogre class definition to illustrate abstract classes.
 *
 * @author CS RIT
 */
public class Ogre extends Monster {

    private final String color;

    public Ogre(String name, int hitPoints, String color) {
        super(name, hitPoints);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void attack(Monster other) {
        System.out.println(getName() + " club " + other.getName() + " hue, hue");
        other.takeDamage(30);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ogre{" +
                "color='" + color + '\'' +
                '}';
    }
}
