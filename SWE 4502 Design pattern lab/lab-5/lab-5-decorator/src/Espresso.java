public class Espresso implements Coffee {

    @Override
    public String getDescription() {
        return "espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}