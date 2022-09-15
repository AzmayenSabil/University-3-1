public class Main {
    public static void main(String[] args) {

        Coffee specialEspresso = new WithMilk(new WithMilk(new Espresso()));

        printCoffee(specialEspresso);
    }

    private static void printCoffee(Coffee c) {
        System.out.println("Cost: " + c.cost() + ", Description: " + c.getDescription());
    }
}
