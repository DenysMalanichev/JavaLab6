public class CarToy extends Toy{

    private int size;

    public CarToy(int size, int price, String name, int minRecommendedAge, int maxRecommendedAge) {
        super(price, name, minRecommendedAge, maxRecommendedAge);
        this.size = size;
    }

    @Override
    public void Play() {
        System.out.println("Rolling a car...");
    }

    @Override
    public String toString() {
        return "CarToy{" +
                "name= " + super.getName() +
                " size= " + size +
                " price= " + super.getPrice() + "$" +
                " recommended for kids from " + super.getMinRecommendedAge() + " to " + super.getMaxRecommendedAge() +
                '}';
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
