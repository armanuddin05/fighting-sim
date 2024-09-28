public class Wolf extends Animal implements Carnivore{
    

    private static final String NAME = "Wolf";

    public Wolf(){
        super();
    };

    public Wolf(int age, double health, double strength){
        super(age, health, strength);
    }

    @Override
    public String getName(){
        return NAME;
    }

    @Override
    public boolean sameSpecies(Animal animal){
        if (animal instanceof Wolf){
            return NAME.equals(animal.getName());
        }
        return false;
    }

    @Override
    public void sleep(){
        setStrength(getStrength() * 1.6);
    }

    @Override
    public boolean isPoisonous(){
        return false;
    }

    
    public void eatAnimal(Animal animal){
        setStrength(getStrength() + (animal.getStrength() * .6));
    }

    @Override
    public String toString(){
        return super.toString() + "; species: Wolf";
    }


}