package inheritance;

/**
 * A basic monster with a name and hit points.
 *
 * @author CS RIT
 */
public abstract class Monster {

    private String name;
    private int hitPoints;

    //default constructor
//    public Monster() {
//        this.name = null;
//        this.hitPoints = 0;
//    }

    public Monster(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public abstract void attack(Monster other);

    public void updateHitPoints(int amount) {
        this.hitPoints += amount;
        if (hitPoints < 0) {
            this.hitPoints = 0;
        }
    }

    public void takeDamage(int amount) {
        System.out.println(getName() + " takes " + amount + " damage");
        updateHitPoints(amount);
        if (hitPoints <= 0) {
            System.out.println(this.name + " has fainted!");
            this.hitPoints = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Monster)) return false;
        Monster other = (Monster) o;
        return hitPoints == other.hitPoints && name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
