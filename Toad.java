
import java.util.Random;
public class Toad extends Animal implements Carnivore{

    private static final String NAME = "Toad";

    public Toad(){
        super();
    }

    public Toad(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Toad){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.2);
    }

    @Override
    public boolean isPoisonous(){
        return true;
    }

    
    public void eatAnimal(Animal animal){
        Random r = new Random();
        double randNum = (r.nextDouble() * 10);
        double newStrength = randNum * (animal.getStrength() * .3);
        setStrength(getStrength() + newStrength);
    }


    @Override
    public boolean poisonAnimal(){
        Random r = new Random();
        double randNum = r.nextDouble();
        if (randNum <= 0.3){
            return true;
        } 
        return false;
    }


    @Override
    public String toString(){
        return super.toString() + "; species: Toad";
    }


}