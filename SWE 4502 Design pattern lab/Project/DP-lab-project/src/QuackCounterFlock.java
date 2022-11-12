import java.util.ArrayList;

public class QuackCounterFlock implements QuackBehaviour{
    private ArrayList<QuackBehaviour> ducks;
    QuackObserver quackObserver;
    int numberOfQuacks = 0;

    public QuackCounterFlock(QuackBehaviour ducks){
        this.ducks = new ArrayList<>();
        //this.ducks = ducks;
        quackObserver = new QuackObserver(this);
        notifyObservers();
    }

    @Override
    public void quack() {
        numberOfQuacks++;
        //ducks.quack();
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
