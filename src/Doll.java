public class Doll extends Toy{

    private String style;

    public Doll(double price, String name, String style, int minRecommendedAge, int maxRecommendedAge) {
        super(price, name, minRecommendedAge, maxRecommendedAge);
        this.style = style;
    }

    @Override
    public void Play() {
        System.out.println("Playing with a doll");
    }

    @Override
    public String toString() {
        return "Doll{" +
                "style= '" + style + "' " +
                "name= " + super.getName() +
                "price= " + super.getPrice() +
                " recommended for kids from " + super.getMinRecommendedAge() + " to " + super.getMaxRecommendedAge() +
                '}';
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
