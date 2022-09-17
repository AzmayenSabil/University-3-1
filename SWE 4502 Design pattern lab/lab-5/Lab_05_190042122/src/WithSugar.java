public class WithSugar extends CoffeeDecorator {

    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return newCoffee.getDescription() + ", with Sugar";
    }

    @Override
    public double cost() {
        return newCoffee.cost() + .25;
    }
}