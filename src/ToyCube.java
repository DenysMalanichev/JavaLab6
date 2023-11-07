public class ToyCube extends Toy{
    private double cubeSideSize;

    public ToyCube(double price, String name, double cubeSideSize, int minRecommendedAge, int maxRecommendedAge) {
        super(price, name, minRecommendedAge, maxRecommendedAge);
        this.cubeSideSize = cubeSideSize;
    }

    @Override
    public void Play() {
        System.out.println("Rolling the ball...");
    }

    @Override
    public String toString() {
        return "ToyCube{" +
                "cubeSideSize=" + cubeSideSize +
                " name= " + super.getName() +
                " price= " + super.getPrice() +
                " recommended for kids from " + super.getMinRecommendedAge() + " to " + super.getMaxRecommendedAge() +
                '}';
    }

    public double getCubeSideSize() {
        return cubeSideSize;
    }

    public void setCubeSideSize(double cubeSideSize) {
        this.cubeSideSize = cubeSideSize;
    }
}
