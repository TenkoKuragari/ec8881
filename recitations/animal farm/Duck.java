public class Duck implements Animal, Swimmer, Flyer {
    public static final double FLY_SPEED_MS = 22.352;
    public static final double RUN_SPEED_MS = 13.94765;
    public static final double SWIM_SPEED_MS = 26.8224;
    private final double wingSpan;
    private final int happiness;

    public Duck(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public double run(int seconds) {
        return 0;
    }

    @Override
    public String speak() {
        return "";
    }

    @Override
    public double fly(int seconds) {
        return 0;
    }

    @Override
    public double dive(int minutes) {
        return 0;
    }

    public static void pet(int seconds) {
        return;
    }

    public int getHapppiness() {
        return happiness;
    }


}
