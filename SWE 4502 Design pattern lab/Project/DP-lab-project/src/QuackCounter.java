public class QuackCounter implements QuackBehaviour {

    QuackBehaviour duck;
    QuackObserver quackObserver;
    int numberOfQuacks = 0;

    public QuackCounter(QuackBehaviour duck){
        this.duck = duck;
        quackObserver = new QuackObserver(this);
        notifyObservers();
    }

    @Override
    public void quack() {
        numberOfQuacks++;
        duck.quack();
    }

    public void getNumberOfQuacks(){
        System.out.println("Number of Quacks : " + numberOfQuacks);;
    }

    @Override
    public void registerObserver(Observer observer) {
        quackObserver.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackObserver.notifyObservers();
    }
}
