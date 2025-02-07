public class Duck extends Animal implements Flyer, Swimmer{

    public final static double FLY_SPEED_MS = 22.352;
    public final static double RUN_SPEED_MS = 13.94765;
    public final static double SWIM_SPEED_MS = 26.8224;
    private final double wingSpan;
    private int happiness;

    public Duck(double wingSpan, String name) {
        super(name);
        this.wingSpan = wingSpan;
    }

    public void pet(int seconds) {
        this.happiness += seconds * wingSpan;
    }

    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public void run(int seconds) {
        travel(seconds * RUN_SPEED_MS + wingSpan);
    }

    @Override
    public String speak() {
        return this.toString() + " says \"quack!, quack\"";
    }

    @Override
    public void fly(int seconds) {
        //TODO
    }

    @Override
    public void dive(int minutes) {
        //TODO
    }

    @Override
    public int getFishEaten() {
        //TODO
        return 0;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }
}
