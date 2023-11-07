import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Playroom {
    private ArrayList<Toy> toys = new ArrayList<>();
    private double budget;

    public Playroom(double budget) {
        this.budget = budget;
    }

    public void addToy(Toy toy) {
        System.out.println("Adding " + toy.getName() + " with price " + toy.getPrice() + '\n');
        if (toy.getPrice() <= budget) {
            toys.add(toy);
            budget -= toy.getPrice();
            System.out.println(toy.getName() + " added. Budget left: " + budget);
        } else {
            System.out.println("The toy is too expensive for the allocated budget.");
        }
    }

    public void sortByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }

    public ArrayList<Toy> findToysInPriceRange(double minPrice, double maxPrice) {
        if(minPrice > maxPrice){
            System.err.println("Wrong price range.");
        }
        ArrayList<Toy> matchingToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                matchingToys.add(toy);
            }
        }
        return matchingToys;
    }

    public void displayToys() {
        System.out.println("Toys in the playroom:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}
