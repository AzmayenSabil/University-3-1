public class Main {
    public static void main(String[] args) {
        Coffee espresso = new Espresso();

        espresso = new WithMilk(espresso);
        espresso = new WithSugar(espresso);
        espresso = new WithSugar(espresso);

        printCoffee(espresso);
    }

    private static void printCoffee(Coffee c) {
        System.out.println("Cost: " + c.cost() + ", Description: " + c.getDescription());
    }
}
