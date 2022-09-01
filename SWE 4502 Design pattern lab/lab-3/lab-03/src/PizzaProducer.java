public class PizzaProducer {
    public static PizzaFactory getFactory(String pizzaFactory){
        if(pizzaFactory.equalsIgnoreCase("pizzahut")){
            System.out.println("PizzaHut :");
            return new Pizzahut();
        }else if(pizzaFactory.equalsIgnoreCase("dominos")){
            System.out.println("Dominos :");
            return new Dominos();
        }
        return null;
    }
}
