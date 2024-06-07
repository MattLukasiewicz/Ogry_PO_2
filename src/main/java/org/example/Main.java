package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Insert here: ");

        int mapChoice = scanner.nextInt();
        String mapFilename;

        switch (mapChoice) {
            case 1:
                mapFilename = "Map1.txt";
                break;
            case 2:
                mapFilename = "Map2.txt";
                break;
            case 3:
                mapFilename = "Map3.txt";
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Map1.txt.");
                mapFilename = "Map1.txt";
        }

        Map map = new Map(mapFilename);
        map.displayMap();

        Move move = new Move(map, hero);
        move.execute();
    }
}
