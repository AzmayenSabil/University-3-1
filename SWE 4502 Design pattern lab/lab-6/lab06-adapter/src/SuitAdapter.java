public class SuitAdapter implements SuperPower{

    Suit ironManSuit;
    public SuitAdapter(Suit suit)
    {
        this.ironManSuit = suit;
    }

    @Override
    public void power() {
        System.out.print("special power -> ");
        ironManSuit.suit();
    }
}
