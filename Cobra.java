
import java.util.Random;
public class Cobra extends Animal implements Carnivore{

    private static final String NAME = "Cobra";

    public Cobra(){
        super();
    }

    public Cobra(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Cobra){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.7);
    }

    @Override
    public boolean isPoisonous(){
        return true;
    }

    
    public void eatAnimal(Animal animal){
        setStrength(getStrength() + (animal.getStrength() * .9));
    }


    @Override
    public boolean poisonAnimal(){
        Random r = new Random();
        double randNum = r.nextDouble();
        if (randNum <= 0.8){
            return true;
        } 
        return false;
    }


    @Override
    public String toString(){
        return super.toString() + "; species: Cobra";
    }


}