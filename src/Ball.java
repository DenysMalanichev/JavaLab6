public class Ball extends Toy{

    private double diameter;

    public Ball(double price, String name, double diameter, int minRecommendedAge, int maxRecommendedAge) {
        super(price, name, minRecommendedAge, maxRecommendedAge);
        this.diameter = diameter;
    }

    @Override
    public void Play() {
        System.out.println("Playing with the ball...");
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name= " + super.getName() +
                " diameter=" + diameter +
                " price= " + super.getPrice() +
                " recommended for kids from " + super.getMinRecommendedAge() + " to " + super.getMaxRecommendedAge() +
                '}';
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
