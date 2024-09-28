
import java.util.Random;
public class Panda extends Animal implements Herbivore{

    private static final String NAME = "Panda";

    public Panda(){
        super();
    }

    public Panda(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Panda){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.4);
    }

    @Override
    public boolean isPoisonous(){
        return false;
    }

    
    public void eatPlant(){
        Random r = new Random();
        double randNum = (r.nextDouble() * 50);
        setStrength(getStrength() + randNum);
    }


    @Override
    public String toString(){
        return super.toString() + "; species: Panda";
    }


}