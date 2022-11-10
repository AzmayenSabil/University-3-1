public class DuckSimulatorMain {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.quack();

        PatiHash patiHash = new PatiHash();
        patiHash.quack();

        QuackBehaviour goose = new DuckAdapter(new Goose());
        goose.quack();

        //--------quack counter-------
        System.out.println();
        QuackCounter quackCounter = new QuackCounter(patiHash);
        quackCounter.quack();
        quackCounter.quack();
        quackCounter.quack();

        quackCounter.getNumberOfQuacks();
        //-----------------------------

        //---------quack counter-------
        System.out.println();
        QuackCounter quackCounter2 = new QuackCounter(duck);
        quackCounter2.quack();
        quackCounter2.quack();
        //quackCounter.quack();

        quackCounter2.getNumberOfQuacks();
        //-----------------------------

        // Used factory pattern to create duck and quack counter
        DuckFactory duckFactory = new DuckFactory();
        QuackBehaviour duck2 = duckFactory.getFactory("patihash");
        System.out.println();
        System.out.println("New duck : ");

        QuackCounterFactory quackCounterFactory = new QuackCounterFactory();
        QuackCounter counter2 = quackCounterFactory.getCounterFactory("count", duck2);
        counter2.quack();
        counter2.getNumberOfQuacks();
        //-------------------------------------------------------

        //-----FLOCK OF DUCKS-------
        FlockOfDucks mainduck = new FlockOfDucks(new Duck());
        QuackBehaviour oneduck = new Duck();
        QuackBehaviour twoduck = new Duck();
        QuackBehaviour threeduck = new PatiHash();

        mainduck.add(oneduck);
        mainduck.add(twoduck);
        mainduck.add(threeduck);

        System.out.println();
        mainduck.quack();

        //--------------------------


    }
}
