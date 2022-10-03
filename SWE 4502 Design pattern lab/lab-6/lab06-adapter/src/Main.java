public class Main {
    public static void main(String[] args) {
        IronMan ironManSuit = new IronMan();
        SuperPower spiderMan = new SpiderMan();

        SuperPower newSuperPower = new SuitAdapter(ironManSuit);

        ironManSuit.suit();
        spiderMan.power();
        newSuperPower.power();
    }
}
