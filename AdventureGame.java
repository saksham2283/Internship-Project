import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You are on a quest to find the legendary treasure. Let the adventure begin!");

        // Start the adventure
        startAdventure(scanner);

        scanner.close();
    }
    private static void findAnotherPath(Scanner scanner) {
        System.out.println("\nYou decide to look for another path. You encounter a bridge and a dense forest.");
        System.out.println("1. Cross the bridge");
        System.out.println("2. Enter the dense forest");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            crossBridge(scanner);
        } else {
            getLostInForest(scanner);
        }
    }
     private static void crossBridge(Scanner scanner) {
        System.out.println("\nYou decide to cross the bridge. On the other side, you encounter a friendly wizard.");
        System.out.println("1. Accept the wizard's help");
        System.out.println("2. Decline the wizard's help");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            System.out.println("The wizard guides you safely through the forest. You continue your adventure.");
            findTreasureRoom(scanner);
        } else {
            System.out.println("Without the wizard's help, you get lost in the forest. Game over!");
        }
    }
    
    private static void findBridge(Scanner scanner) {
        System.out.println("\nYou search and find a hidden bridge. As you cross, you hear a mysterious voice.");
        System.out.println("1. Follow the voice");
        System.out.println("2. Ignore the voice and continue exploring");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            System.out.println("The voice leads you to a secret passage. You discover a hidden treasure room!");
            findTreasureRoom(scanner);
        } else {
            System.out.println("You ignore the voice and find a winding path that leads to a labyrinth. Game over!");
        }
    }

    private static void getLostInForest(Scanner scanner) {
        System.out.println("\nThe dense forest is confusing, and you get lost.");
        System.out.println("After wandering for hours, you find a mysterious portal.");
        System.out.println("1. Enter the portal");
        System.out.println("2. Stay in the forest and keep searching");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            System.out.println("You enter the portal and find yourself back at the entrance of the cave.");
            startAdventure(scanner);
        } else {
            System.out.println("You continue searching but never find your way out. Game over!");
        }
    }

    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = -1;
        do {
            System.out.print("Enter your choice (1-" + maxChoice + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // User entered non-numeric input
            }

            if (choice < 1 || choice > maxChoice) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice + ".");
            }

        } while (choice < 1 || choice > maxChoice);

        return choice;
    }
    private static void startAdventure(Scanner scanner) {
        System.out.println("\nYou find yourself in front of a dark cave. What will you do?");
        System.out.println("1. Enter the cave");
        System.out.println("2. Look for another path");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            exploreCave(scanner);
        } else {
            findAnotherPath(scanner);
        }
    }

    private static void exploreCave(Scanner scanner) {
        System.out.println("\nAs you enter the cave, you see two tunnels. Which one will you choose?");
        System.out.println("1. Take the left tunnel");
        System.out.println("2. Take the right tunnel");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            encounterDragon(scanner);
        } else {
            findTreasureRoom(scanner);
        }
    }

    private static void encounterDragon(Scanner scanner) {
        System.out.println("\nOh no! You encounter a fierce dragon in the left tunnel!");
        System.out.println("1. Try to sneak past the dragon");
        System.out.println("2. Fight the dragon");
        System.out.println("3. Offer a shiny object to distract the dragon");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("You manage to sneak past the dragon and continue your journey.");
            findUndergroundRiver(scanner);
        } else if (choice == 2) {
            System.out.println("The dragon is too powerful, and you are defeated. Game over!");
        } else {
            System.out.println("The shiny object distracts the dragon, allowing you to slip away unnoticed.");
            findUndergroundRiver(scanner);
        }
    }

    private static void findUndergroundRiver(Scanner scanner) {
        System.out.println("\nWhile exploring further, you discover an underground river blocking your path.");
        System.out.println("1. Swim across the river");
        System.out.println("2. Search for a bridge");
        System.out.println("3. Find a boat to navigate the river");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("You successfully swim across the river and reach a mysterious chamber.");
            findChamberOfCrystals(scanner);
        } else if (choice == 2) {
            findBridge(scanner);
        } else {
            System.out.println("You find a small boat and navigate the river. It leads you to an ancient cavern.");
            exploreAncientCavern(scanner);
        }
    }
    private static void exploreAncientCavern(Scanner scanner) {
        System.out.println("\nYou enter the ancient cavern filled with mysterious artifacts and ancient inscriptions.");
        System.out.println("1. Examine the ancient artifacts");
        System.out.println("2. Read the inscriptions on the cavern walls");
        System.out.println("3. Look for a hidden passage");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("While examining the artifacts, you find a magical amulet that enhances your abilities.");
            findHiddenPassage(scanner);
        } else if (choice == 2) {
            System.out.println("The inscriptions reveal a hidden message pointing to the treasure room. You continue your journey.");
            findTreasureRoom(scanner);
        } else {
            System.out.println("You discover a concealed passage that leads to an underground labyrinth.");
            exploreUndergroundLabyrinth(scanner);
        }
    }
    private static void exploreUndergroundLabyrinth(Scanner scanner) {
        System.out.println("\nYou navigate through the underground labyrinth with twisting passages.");
        System.out.println("1. Follow the left path");
        System.out.println("2. Follow the right path");
        System.out.println("3. Search for a shortcut");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("The left path leads to a dead-end. You backtrack and find a hidden door to the treasure room!");
            findTreasureRoom(scanner);
        } else if (choice == 2) {
            System.out.println("The right path takes you deeper into the labyrinth. You discover a hidden treasure room!");
            findTreasureRoom(scanner);
        } else {
            System.out.println("You search for a shortcut and accidentally stumble upon a secret exit. It leads you directly to the treasure room!");
            findTreasureRoom(scanner);
        }
    }


  
    private static void findTreasureRoom(Scanner scanner) {
        System.out.println("\nCongratulations! You enter a room filled with glittering treasure.");
        System.out.println("You have successfully found the legendary treasure. You win!");
    }

    private static void findChamberOfCrystals(Scanner scanner) {
        System.out.println("\nIn the chamber, you find glowing crystals illuminating three passages.");
        System.out.println("1. Take the left passage");
        System.out.println("2. Take the middle passage");
        System.out.println("3. Take the right passage");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            encounterGoblins(scanner);
        } else if (choice == 2) {
            System.out.println("You find a magical portal that transports you to a high mountain peak.");
            climbMountain(scanner);
        } else {
            System.out.println("The passage leads to a dead-end. You backtrack and find a hidden door to the treasure room!");
            findTreasureRoom(scanner);
        }
    }

    private static void encounterGoblins(Scanner scanner) {
        System.out.println("\nAs you proceed, a group of mischievous goblins ambush you!");
        System.out.println("1. Try to negotiate with the goblins");
        System.out.println("2. Fight the goblins");
        System.out.println("3. Sing a goblin song to befriend them");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("You successfully negotiate with the goblins and they show you a secret passage.");
            findHiddenPassage(scanner);
        } else if (choice == 2) {
            System.out.println("The goblins are tough, but you manage to defeat them. You discover a hidden treasure room!");
            findTreasureRoom(scanner);
        } else {
            System.out.println("Your goblin song enchants the goblins, and they guide you to a secret goblin market.");
            exploreGoblinMarket(scanner);
        }
    }

    private static void exploreGoblinMarket(Scanner scanner) {
        System.out.println("\nIn the goblin market, you find peculiar items for sale.");
        System.out.println("1. Buy a magical potion");
        System.out.println("2. Trade your shiny object for a goblin artifact");
        System.out.println("3. Challenge a goblin to a riddle contest");

        int choice = getUserChoice(scanner, 3);

        if (choice == 1) {
            System.out.println("The magical potion enhances your abilities. You continue your journey.");
            findHiddenPassage(scanner);
        } else if (choice == 2) {
            System.out.println("The goblin artifact is powerful and aids you in your quest.");
            findHiddenPassage(scanner);
        } else {
            riddleContestWithGoblin(scanner);
        }
    }

    private static void riddleContestWithGoblin(Scanner scanner) {
        System.out.println("\nYou challenge a goblin to a riddle contest.");
        System.out.println("Your riddle: What has a heart that doesn't beat?");
        System.out.println("Goblin's riddle: The more you take, the more you leave behind. What am I?");

        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("artichoke")) {
            System.out.println("Congratulations! You outsmart the goblin. It gives you a map to the treasure room.");
            findTreasureRoom(scanner);
        } else {
            System.out.println("The goblin's riddle is a classic. It's footprints! You lose the contest and must find another path.");
            findAnotherPath(scanner);
        }
    }

    private static void findHiddenPassage(Scanner scanner) {
        System.out.println("\nThe goblins reveal a hidden passage that leads to an ancient library.");
        System.out.println("1. Explore the library");
        System.out.println("2. Leave the library and continue the quest");

        int choice = getUserChoice(scanner, 2);

        if (choice == 1) {
            System.out.println("You find a map in the library that guides you to the heart of the treasure room!");
            findTreasureRoom(scanner);
        } else {
            System.out.println("You leave the library and encounter a friendly spirit. It guides you to the treasure room!");
            findTreasureRoom(scanner);
        }
    }

    private static void climbMountain(Scanner scanner) {
        System.out.println("\nAt the mountain peak, you face a challenge: a riddle from a wise old eagle.");
        System.out.println("Answer the riddle to proceed.");
        System.out.println("Riddle: What has keys but can't open locks?");

        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("piano")) {
            System.out.println("Correct! The eagle allows you to descend the mountain and find the treasure room.");
            findTreasureRoom(scanner);
        } else {
            System.out.println("Incorrect! The eagle is disappointed, and you are sent back to the chamber of crystals. Try again!");
            findChamberOfCrystals(scanner);
        }
    }
}
