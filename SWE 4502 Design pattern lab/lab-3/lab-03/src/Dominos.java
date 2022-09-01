public class Dominos extends PizzaFactory{
    @Override
    public Pizza getPizza(String pizzaType) {
        if(pizzaType.equalsIgnoreCase("cheese")){
            return new CheesePizza();
        }else if(pizzaType.equalsIgnoreCase("veg")){
            return new VeggiePizza();
        }
        return null;
    }
}
