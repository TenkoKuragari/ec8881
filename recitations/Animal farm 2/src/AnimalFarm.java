import java.util.ArrayList;

/**
 * CSCI-142 Computer Science 2 Recitation Exercise
 * 04-Inheritance
 * Animal Farm
 *
 * A test program for the 2 kinds of animals, e.g. camels and penguins.
 * The animals that possess a particular behavior, e.g. running,
 * speaking (Animal), diving (Swimmer) are exercised.
 *
 * In the end the unique behavior of each animal is exercised individually
 * and the total distance all animals travelled is computed/displayed.
 *
 * $ java AnimalFarm
 * Farm: camelMilk=0.0, penguinFish=0
 * 	Animal{name='Joe, distance=0.0', Camel{numHumps=1,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Pingu, distance=0.0', Penguin{beakLength=10,
 * 	    fishEaten=0}}
 * 	Animal{name='Larry, distance=0.0', Camel{numHumps=2,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Tux, distance=0.0', Penguin{beakLength=20,
 * 	    fishEaten=0}}
 *
 * RUNNING and SPEAKING the animals for 5 seconds each...
 * 	Animal{name='Joe, distance= 89.40799999999999', Camel{numHumps=1,
 * 	    litersMilked=0.0}} says, "grunt!, grunt!"
 * 	Animal{name='Pingu, distance= 15.6464', Penguin{beakLength=10,
 * 	    fishEaten=0}} says, "gak! gak!"
 * 	Animal{name='Larry, distance= 44.70399999999999', Camel{numHumps=2,
 * 	    litersMilked=0.0}} says, "grunt!, grunt!"
 * 	Animal{name='Tux, distance= 15.6464', Penguin{beakLength=20,
 * 	    fishEaten=0}} says, "gak! gak!"
 *
 * Farm: camelMilk=0.0, penguinFish=0
 * 	Animal{name='Joe, distance=89.40799999999999', Camel{numHumps=1,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Pingu, distance=15.6464', Penguin{beakLength=10,
 * 	    fishEaten=0}}
 * 	Animal{name='Larry, distance=44.70399999999999', Camel{numHumps=2,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Tux, distance=15.6464', Penguin{beakLength=20,
 * 	    fishEaten=0}}
 *
 * SWIMMING the animals for 10 minutes each...
 * 	Animal{name='Pingu, distance=1222.6544000000001',
 * 	    Penguin{beakLength=10, fishEaten=400}}
 * 	Animal{name='Tux, distance=1222.6544000000001',
 * 	    Penguin{beakLength=20, fishEaten=800}}
 *
 * Farm: camelMilk=0.0, penguinFish=0
 * 	Animal{name='Joe, distance=89.40799999999999', Camel{numHumps=1,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Pingu, distance=1222.6544000000001',
 * 	    Penguin{beakLength=10, fishEaten=400}}
 * 	Animal{name='Larry, distance=44.70399999999999', Camel{numHumps=2,
 * 	    litersMilked=0.0}}
 * 	Animal{name='Tux, distance=1222.6544000000001',
 * 	    Penguin{beakLength=20, fishEaten=800}}
 *
 * INTERACTING with animals uniquely...
 * 	Milking camel for 30 seconds...
 * 		Animal{name='Joe, distance=89.40799999999999',
 * 		    Camel{numHumps=1, litersMilked=261.19350000000003}}
 * 		    says, "grunt!, grunt!"
 * 		Animal{name='Larry, distance=44.70399999999999',
 * 		    Camel{numHumps=2, litersMilked=261.19350000000003}}
 * 		    says, "grunt!, grunt!"
 * 	Getting fish eaten from penguin...
 * 		Animal{name='Pingu, distance=1222.6544000000001',
 * 		    Penguin{beakLength=10, fishEaten=400}} says, "gak! gak!"
 * 		Animal{name='Tux, distance=1222.6544000000001',
 * 		    Penguin{beakLength=20, fishEaten=800}} says, "gak! gak!"
 *
 * Farm: camelMilk=522.3870000000001, penguinFish=1200
 * 	Animal{name='Joe, distance=89.40799999999999', Camel{numHumps=1,
 * 	    litersMilked=261.19350000000003}}
 * 	Animal{name='Pingu, distance=1222.6544000000001',
 * 	    Penguin{beakLength=10, fishEaten=400}}
 * 	Animal{name='Larry, distance=44.70399999999999', Camel{numHumps=2,
 * 	    litersMilked=261.19350000000003}}
 * 	Animal{name='Tux, distance=1222.6544000000001',
 * 	    Penguin{beakLength=20, fishEaten=800}}
 *
 * Total distance all animals travelled: 2579.4208
 *
 * @author RIT CS
 */
public class AnimalFarm {
    /** the collection of animals */
    private ArrayList<Animal> animals;
    /** the collection of swimmers */
    private ArrayList<Swimmer> swimmers;
    /** the collection of camels */
    private ArrayList<Camel> camels;
    /** the collection of penguins */
    private ArrayList<Penguin> penguins;
    /** how much milk the camels produced */
    private double camelMilk;
    /** how many fish the penguins ate */
    private int penguinFish;

    /**
     * Create the farm and add the animals.
     */
    public AnimalFarm() {
        this.animals = new ArrayList<>();
        this.swimmers = new ArrayList<>();
        this.camels = new ArrayList<>();
        this.penguins = new ArrayList<>();
        this.camelMilk = 0;
        this.penguinFish = 0;

        // create unique references to each animal
        Camel joe = new Camel(1, "Joe");
        Camel larry = new Camel(2, "Larry");
        Penguin pingu = new Penguin(10, "Pingu");
        Penguin tux = new Penguin(20, "Tux");

        // add the animals
        this.animals.add(joe);
        this.animals.add(pingu);
        this.animals.add(larry);
        this.animals.add(tux);

        // add the swimmers
        this.swimmers.add(pingu);
        this.swimmers.add(tux);

        // add the camels
        this.camels.add(joe);
        this.camels.add(larry);

        // add the penguins
        this.penguins.add(pingu);
        this.penguins.add(tux);
    }

    /**
     * Run and speak all animals in the farm.  This includes all of the
     * animals since they all implement the Animal interface.
     */
    private void runAndSpeakAnimals() {
        System.out.println("RUNNING and SPEAKING the animals for 5" +
                " seconds each...");
        for (Animal animal : this.animals) {
            animal.runAndSpeak(5);
        }
    }

    /**
     * For animals in the farm that implement the Swimmer interface, have
     * them swim for 10 minutes each.
     */
    private void swimAnimals() {
        System.out.println("SWIMMING the animals for 10 minutes each...");
        for (Swimmer swimmer : this.swimmers) {
            swimmer.dive(10);
            System.out.println("\t" + swimmer);
        }
    }

    /**
     * Each different kind of animal has a unique behavior, i.e. the camel
     * can be milked (30 seconds), and the penguin can eat fish.
     */
    public void interactAnimals() {
        System.out.println("INTERACTING with animals uniquely...");
        System.out.println("\tMilking camel for 30 seconds...");
        for (Camel camel : this.camels) {
            camel.milk(30);
            this.camelMilk += camel.getLitersMilked();
            System.out.println("\t\t" + camel.speak());
        }

        System.out.println("\tGetting fish eaten from penguin...");
        for (Penguin penguin : this.penguins) {
            this.penguinFish += penguin.getFishEaten();
            System.out.println("\t\t" + penguin.speak());
        }
    }

    /**
     * Get the total distance all animals travelled.
     *
     * @return total distance
     */
    public double getTotalDistanceTravelled() {
        double total = 0;
        for (Animal animal : this.animals) {
            total += animal.getDistance();
        }
        return total;
    }

    /**
     * Return a string representation of the animal farm.  This includes
     * all the statistics of the farm and the state of each animal, e.g.
     * at the start:
     *
     * "camelMilk=0.0, penguinFish=0
     * Animal{name='Joe, distance= 0.0', Camel{numHumps=1,
     *     litersMilked=0.0}}
     * Animal{name='Pingu, distance= 0.0', Penguin{beakLength=10,
     *     fishEaten=0}}
     * Animal{name='Larry, distance= 0.0', Camel{numHumps=2,
     *     litersMilked=0.0}}
     * Animal{name='Tux, distance= 0.0', Penguin{beakLength=20,
     *     fishEaten=0}}
     *
     * @return the string representation
     *
     */
    @Override
    public String toString() {
        String result = "camelMilk=" + this.camelMilk +
                ", penguinFish=" + this.penguinFish +
                "\n";
        for (Animal animal : this.animals) {
            result += "\t" + animal.toString() + "\n";
        }
        return result;
    }

    /**
     * The main program exercises the animals in various ways and prints out
     * the farm after each different exercise.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm();
        System.out.println("\nFarm: " + farm);
        farm.runAndSpeakAnimals();
        System.out.println("\nFarm: " + farm);
        farm.swimAnimals();
        System.out.println("\nFarm: " + farm);
        farm.interactAnimals();
        System.out.println("\nFarm: " + farm);
        System.out.println("Total distance all animals travelled: " +
                farm.getTotalDistanceTravelled());
    }
}


