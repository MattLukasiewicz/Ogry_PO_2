package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Program mode selectioon
        System.out.println("Choose mode of the program:");
        System.out.println("1. Custom play");
        System.out.println("2. Simulation");
        System.out.println("Insert here: ");
        int modeChoice=scanner.nextInt();

        switch(modeChoice){
            case 1:
                // Hero selection
                System.out.println("Choose your hero:");
                System.out.println("1. Shrek");
                System.out.println("2. Batman");
                System.out.println("3. Santa Claus");
                System.out.println("Insert here: ");

                int heroChoice = scanner.nextInt();
                Harvester hero;

                switch (heroChoice) {
                    case 1:
                        hero = new Shrek("Shrek", '%', 280, 1.0);
                        break;
                    case 2:
                        hero = new Batman("Batman", '#', 190, 1);
                        break;
                    case 3:
                        hero = new Santa_Claus("Santa Claus", '@', 160, 1);
                        break;
                    default:
                        System.out.println("Invalid choice! Defaulting to Shrek.");
                        hero = new Shrek("Shrek", '%', 280, 1.0);
                }

                // Map selection
                System.out.println("Choose your map:");
                System.out.println("1. Map1.txt");
                System.out.println("2. Map2.txt");
                System.out.println("3. Map3.txt");
                System.out.println("4. Random Map");
                System.out.println("Insert here: ");

                int mapChoice = scanner.nextInt();
                String mapFilename;
                Map map;

                switch (mapChoice) {
                    case 1:
                        mapFilename = "Map1.txt";
                        map = new Map(mapFilename);
                        break;
                    case 2:
                        mapFilename = "Map2.txt";
                        map = new Map(mapFilename);
                        break;
                    case 3:
                        mapFilename = "Map3.txt";
                        map = new Map(mapFilename);
                        break;
                    case 4:
                        map = new Map();
                        break;
                    default:
                        System.out.println("Invalid choice! Defaulting to Map1.txt.");
                        mapFilename = "Map1.txt";
                        map = new Map(mapFilename);
                }


                map.displayMap();

                Move move = new Move(map, hero);
                move.execute();
                break;
            case 2:
                System.out.println("How many simulations do you want to run?");
                int howManySimulations = scanner.nextInt();
                System.out.println("Do you want to display every map?");
                System.out.println("Yes(1), No(0)");
                int mapDisplaySimulation = scanner.nextInt();

                Harvester[] heros = {
                        new Shrek("Shrek", '%', 280, 1.0),
                        new Batman("Batman", '#', 190, 1),
                        new Santa_Claus("Santa Claus", '@', 160, 1)
                };

                for (int i = 0; i < howManySimulations; i++) {
                    map = new Map();
                    if(mapDisplaySimulation==1) map.displayMap();
                    for (Harvester simHero : heros) {
                        Move moveSimulation = new Move(map, simHero);
                        moveSimulation.execute();
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }



    }
}
