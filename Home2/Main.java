package Home2;

import java.util.Scanner;

/**
 * Created by user on 31.12.2016.
 */
public class Main {
        public static void fight(Pokemon poke1, Pokemon poke2) {

            Scanner in = new Scanner(System.in);
            int trainerStep1;
            int trainerStep2;

            poke1.setMode(Pokemon.mode.FIGHT);
            poke2.setMode(Pokemon.mode.FIGHT);
            System.out.println("POKEMONS: "+ poke1.getName()+"   &  "+ poke2.getName());

            while(!poke1.stopFight() & !poke2.stopFight()) {

                System.out.println("STATUS "+poke1.getName()+" "+ poke1.getHealth()+" " + poke2.getName() + " " + poke2.getHealth());

                System.out.println("Trainer №1: 1 - damage, 2 - pass, 0 - quit ");
                trainerStep1 = in.nextInt();

                switch(trainerStep1) {
                        case 1:{
                            poke2.setHealth(poke2.getHealth() - poke1.getPower());
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 0: {
                            System.out.println("END");
                            break;
                        }
                        default: System.out.println("WRONG: input 1, 2 or 0 only");
                            break;
                    }

                    if (poke2.stopFight()) {
                        break;
                    }

                System.out.println("Trainer №2: 1 - damage, 2 - pass, 0 - quit ");
                trainerStep2 = in.nextInt();

                switch(trainerStep2) {
                    case 1:{
                        poke1.setHealth(poke1.getHealth() - poke2.getPower());
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 0: {
                        System.out.println("END");
                        return;
                    }
                    default: System.out.println("WRONG: input 1, 2 or 0 only");
                        break;
                }
            }

            System.out.println("STATUS "+poke1.getName()+" "+ poke1.getHealth()+" " + poke2.getName() + " " + poke2.getHealth());

            if (poke1.getHealth() > poke2.getHealth()){
                System.out.println(poke1.getName()+ " WIN Energy: " + poke1.getHealth());
            }
            else{
                System.out.println(poke2.getName()+ " WIN Energy: " + poke2.getHealth());
            }
        }

    public static void main(String[] args) {

        Pokemon pokemon1= new Pokemon(100, "POKE1", 10, 1);
        Pokemon pokemon2 = new Pokemon(200, "POKE2", 5, 1);

        pokemon1.train();
        pokemon2.train();

        fight(pokemon1, pokemon2);
    }
}
