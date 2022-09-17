public abstract class CoffeeDecorator implements Coffee {

    protected Coffee newCoffee;

    public CoffeeDecorator(Coffee newCoffee){
        this.newCoffee = newCoffee;
    }

    @Override
    public String getDescription() {
        return newCoffee.getDescription();
    }

    @Override
    public double cost() {
        return newCoffee.cost();
    }

}