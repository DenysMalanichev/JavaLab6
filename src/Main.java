import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter budget for playroom: ");
        double budget = getNum();

        Playroom playroom = new Playroom(budget);

        playroom.addToy(new CarToy(10, 125, "Red Car", 6, 12));
        playroom.addToy(new Doll(160, "Barbie", "classic doll", 9,12));
        playroom.addToy(new Ball(50, "Football", 5.0, 5, Integer.MAX_VALUE));
        playroom.addToy(new CarToy(5, 75, "Green Hot Wheels Car", 6, 12));
        playroom.addToy(new Ball(50, "Basketball", 7.0, 5, Integer.MAX_VALUE));

        System.out.println("----------------------------");

        System.out.println("Sorted by price: ");
        playroom.sortByPrice();
        playroom.displayToys();

        System.out.println("----------------------------");

        System.out.println("Enter min price for search: ");
        double minPrice = getNum();

        System.out.println("Enter max price for search: ");
        double maxPrice = getNum();

        findToysInPriceRange(playroom, minPrice, maxPrice);

    }

    private static void findToysInPriceRange(Playroom playroom, double minPrice, double maxPrice) {
        ArrayList<Toy> toysInRange = playroom.findToysInPriceRange(minPrice, maxPrice);
        if(!toysInRange.isEmpty()){
            System.out.println("\nToys in the price range of $" + minPrice + " to $" + maxPrice + ":");
            for (Toy toy : toysInRange) {
                System.out.println(toy);
            }
        }
        else {
            System.err.println("No games in given range ($" + minPrice + " to $" + maxPrice + ").");
        }
    }

    private static int getNum() {
        int ans = 0;
        boolean validInput;
        Scanner sc = new Scanner(System.in);
        do {
            validInput = true;
            try {
                ans = sc.nextInt();
                if (ans < 1) {
                    System.err.println("Too short. Please enter number that is equal or greater than 1.");
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter number that is equal or greater than 1.");
                validInput = false;
                sc.nextLine();
            }
        } while (!validInput);

        return ans;
    }
}