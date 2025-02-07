public class Duck extends Animal implements Flyer, Swimmer{

    public final static double FLY_SPEED_MS = 22.352;
    public final static double RUN_SPEED_MS = 13.94765;
    public final static double SWIM_SPEED_MS = 26.8224;
    private double wingSpan;
    private int happiness;

    public Duck(double wingSpan, String name) {
        super(name);
        this.wingSpan = wingSpan;
    }

    public void pet(int seconds) {
        //TODO
    }

    public int getHappiness() {
        //TODO
        return 0;
    }

    @Override
    public void run(int seconds) {
        //TODO
    }

    @Override
    public String speak() {
        //TODO
        return "";
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
