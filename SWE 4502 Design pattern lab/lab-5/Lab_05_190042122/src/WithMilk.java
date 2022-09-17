public class WithMilk extends CoffeeDecorator {


    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return newCoffee.getDescription() + ", with Milk ";
    }

    @Override
    public double cost() {
        return newCoffee.cost() + .50;
    }
}
