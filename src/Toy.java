public abstract class Toy {
    private double price;
    private String name;
    private int minRecommendedAge;
    private int  maxRecommendedAge;

    public Toy(double price, String name, int minRecommendedAge, int maxRecommendedAge) {
        this.price = price;
        this.name = name;
        this.minRecommendedAge = minRecommendedAge;
        this.maxRecommendedAge = maxRecommendedAge;
    }

    public abstract void Play();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMinRecommendedAge() {
        return minRecommendedAge;
    }

    public void setMinRecommendedAge(int minRecommendedAge) {
        this.minRecommendedAge = minRecommendedAge;
    }

    public int getMaxRecommendedAge() {
        return maxRecommendedAge;
    }

    public void setMaxRecommendedAge(int maxRecommendedAge) {
        this.maxRecommendedAge = maxRecommendedAge;
    }
}
