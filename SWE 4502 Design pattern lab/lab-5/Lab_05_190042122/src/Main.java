public class Main {

    public static void main(String[] args) {

        CoffeeDecoratingFactory decoratingFactory = new CoffeeDecoratingFactory();

        CoffeeFactory coffee = new CoffeeFactory();
        Coffee c1 = coffee.createElement();

        c1.getDescription();

        c1 = decoratingFactory.addMilk(c1);
        c1 = decoratingFactory.addSugar(c1);

        c1.cost();
        c1.getDescription();



    }

}