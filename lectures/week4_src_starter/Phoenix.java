package inheritance;

/**
 * The mighty Phoenix possesses the power of flight and can regenerate
 * hit points when taking damage if the damage is non-critical.
 *
 * @author CS RIT
 */
public class Phoenix extends Monster implements Flyer {
    /**
     * how far has this phoenix flown?
     */
    private int distance;

    public Phoenix(String name, int hitPoints) {
        super(name, hitPoints);
        this.distance = 0;
    }

    @Override
    public void attack(Monster other) {
        System.out.println(getName() + " claws " + other.getName() + " kaw kaw");
        other.takeDamage(15);
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage(amount);
        if (getHitPoints() > 0) {
            System.out.println(getName() + " regens 10 points");
            updateHitPoints(10);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Phoenix{distance=" + distance + "}";
    }

    @Override
    public void fly(int distance) {
        this.distance += distance;

    }
}