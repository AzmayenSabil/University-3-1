
public class Main {
    public static void main(String[] args) {

        Context context = new Context(new NewYearDiscount(), 20);
        context.giveDiscount();

        Context context2 = new Context(new EidDiscount(), 35);
        context2.giveDiscount();


    }
}
