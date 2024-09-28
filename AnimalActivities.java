

public class AnimalActivities{

    private AnimalActivities(){};

    public static int fight(Animal animal1, Animal animal2){

        boolean a1IsPois = false;
        boolean a2IsPois = false;
        boolean a1IsDead = false;
        boolean a2IsDead = false;
        int roundNum = 0;

        if(animal1.getHealth() <= 0){
            a1IsDead = true;
        }
        if(animal2.getHealth() <=0){
            a2IsDead = true;
        }



        if(animal1.isPoisonous()){
            a1IsPois = animal1.poisonAnimal();
            
        }
        if(animal2.isPoisonous()){
            a2IsPois = animal2.poisonAnimal();

        }

        while (animal1.getHealth() > 0 && animal2.getHealth() > 0){
            printRound(roundNum);
            printBothAnimals(animal1, animal2);
            printAttack(LEFT, animal1.attack(animal2));
            printAttack(RIGHT, animal2.attack(animal1));
            roundNum++;
        }

        printFinalStats(animal1, animal2, a1IsPois || a2IsPois);

        if (a1IsDead == true && a2IsDead == true){
            printTieGame();
            return 0;
        }

        if(animal1.getHealth() > 0){
            if (a1IsPois == true){
                printTieGame();
                return 0;
            }
            if (animal1 instanceof Carnivore){
                ((Carnivore)animal1).eatAnimal(animal2);
            }
            else if (animal1 instanceof Herbivore){
                ((Herbivore)animal1).eatPlant();
            }

            printWinner(LEFT);
            return 1;
        }


        if(animal2.getHealth() > 0){
            if (a2IsPois == true){
                printTieGame();
                return 0;
            }
            if (animal2 instanceof Carnivore){
                ((Carnivore)animal2).eatAnimal(animal1);
            }
            else if (animal2 instanceof Herbivore){
                ((Herbivore)animal2).eatPlant();
            }

            printWinner(RIGHT);
            return 2;
        }
        return 0;
    }

    public static Animal reproduce(Animal animal1, Animal animal2){
        boolean ofAge = false;
        boolean areSame = false;

        if (animal1.getAge() > 5 && animal2.getAge() > 5){
            ofAge = true;
        }
        if (animal1.sameSpecies(animal2)){
            areSame = true;
        }

        if (ofAge == true && areSame == true){

            double newStrength = ((animal1.getStrength() + animal2.getStrength()) / 2) / 2;

            Animal newAnimal;


            if (animal1 instanceof Wolf && animal2 instanceof Wolf){
                newAnimal = new Wolf(0, 100, newStrength);
                return newAnimal;
            }
            else if (animal1 instanceof Leopard && animal2 instanceof Leopard){
                newAnimal = new Leopard(0, 100, newStrength);
                return newAnimal;
            }
            else if (animal1 instanceof Toad && animal2 instanceof Toad){
                newAnimal = new Toad(0, 100, newStrength);
                return newAnimal;
            }
            else if (animal1 instanceof Cobra && animal2 instanceof Cobra){
                newAnimal = new Cobra(0, 100, newStrength);
                return newAnimal;
            }
            else if (animal1 instanceof Panda && animal2 instanceof Panda){
                newAnimal = new Panda(0, 100, newStrength);
                return newAnimal;
            }
            else if (animal1 instanceof Zebra && animal2 instanceof Zebra){
                newAnimal = new Zebra(0, 100, newStrength);
                return newAnimal;
            }
        }
        
        
        
        return null;
    }








    /* Below are helper methods to make fight() work */
    /**
    * Use this method in fight() to display the stats of both animals together
    *
    * @param (animal1) Animal on the left side to display stats
    * @param (animal2) Animal on the right side to display stats
    */
    public static void printBothAnimals(Animal animal1, Animal animal2) {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(String.format("%.2f",animal1.getHealth()));
        int strSpacing = calcSpacing(String.format("%.2f",animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getName());
        String str = String.format( "(%s) %s (%s)\n" +
        "----------" + " " + "----------\n" +
        "A: %d %s A: %d\n" +
        "H: %.2f %s H: %.2f\n" +
        "S: %.2f %s S: %.2f\n", animal1.getName(),
        " ".repeat(animalSpacing),animal2.getName(),
        animal1.getAge()," ".repeat(ageSpacing),animal2.getAge(),
        animal1.getHealth(), " ".repeat(healthSpacing), animal2.getHealth(),
        animal1.getStrength(), " ".repeat(strSpacing), animal2.getStrength()
        );
        System.out.println(str);
    }
        /**
        * Helper method for printBothAnimals()
        *
        * @param (str) String on the left - used to calculate spacing
        * @return An int describing how many spaces to put between strings
        */
        public static int calcSpacing(String str) {
            int totalWidth = SPACING;
            int str1Width = str.length();
            int spacing = (totalWidth - str1Width);
            if (spacing < 0) {
            return 0;
            }
            return spacing;
        }
        /**
        * Use this method in fight() to display the current round.
        * @param (round) An int of the round (should start at 0)
        */
        public static void printRound(int round) {
            System.out.println();
            System.out.println("Round " + round + ":");
        }
        /**
        * Use this method in fight() to display the damage each round.
        *
        * @param (side) The side of the Animal that invoked the attack().
        * @param (damage) The int (damage) returned from an attack() call
        */
        public static void printAttack(String side, double damage) {
            System.out.printf("%s does %.2f damage!\n",side, damage);
        }
        /**
        * Use this method in fight() to display final stats and poison status.
        *
        * @param (animal1) Left animal
        * @param (animal2) Right animal
        * @param (poisoned) If either animal was poisoned
        */
        public static void printFinalStats(Animal animal1, Animal animal2,
        boolean poisoned) {
            System.out.println();
            printBothAnimals(animal1, animal2);
            if (poisoned) {
                System.out.println("An animal was poisoned.");
            }
        }
        /**
        * Use this method in fight() to display a tie game.
        */
        public static void printTieGame() {
            System.out.println("-------GAME OVER-------");
            System.out.println("TIE: Both animals died!");
        }
        /**
        * Use this method in fight() to display the winner.
        * @param (side) The side of the Animal that won.
        */
        public static void printWinner(String side) {
            System.out.println("-------GAME OVER-------");
            System.out.println(side + " animal wins!");
        }

        

        // Necessary constants
        private final static int SPACING = 17;
        private final static String LEFT = "Left";
        private final static String RIGHT = "Right";


}