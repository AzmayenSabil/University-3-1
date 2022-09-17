public class Mocha implements Coffee {
    @Override
    public String getDescription() {
        return "Mocha";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}
