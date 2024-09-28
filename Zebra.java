
import java.util.Random;
public class Zebra extends Animal implements Herbivore{

    private static final String NAME = "Zebra";

    public Zebra(){
        super();
    }

    public Zebra(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Zebra){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.3);
    }

    @Override
    public boolean isPoisonous(){
        return false;
    }

    
    public void eatPlant(){
        Random r = new Random();
        double randNum = r.nextDouble() * 40;
        setStrength(getStrength() + randNum);
    }


    @Override
    public String toString(){
        return super.toString() + "; species: Zebra";
    }


}