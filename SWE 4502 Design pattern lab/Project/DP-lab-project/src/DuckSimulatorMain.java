public class DuckSimulatorMain {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.quack();

        PatiHash patiHash = new PatiHash();
        patiHash.quack();

        QuackBehaviour goose = new DuckAdapter(new Goose());
        goose.quack();

        QuackCounter quackCounter = new QuackCounter(patiHash);
        quackCounter.quack();
        quackCounter.quack();
        //quackCounter.quack();

        quackCounter.getNumberOfQuacks();

    }
}
