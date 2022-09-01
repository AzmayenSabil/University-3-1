public class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = PizzaProducer.getFactory("dominos");
        Pizza pizza1 = pizzaFactory.getPizza("veg");
        pizza1.prepare();

        PizzaFactory pizzaFactory2 = PizzaProducer.getFactory("pizzahut");
        Pizza pizza2 = pizzaFactory2.getPizza("cheese");
        pizza2.prepare();
    }
}
