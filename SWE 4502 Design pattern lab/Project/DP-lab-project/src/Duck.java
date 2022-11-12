public class Duck implements QuackBehaviour {

    QuackObserver quackObserver;

    public Duck(){
        quackObserver = new QuackObserver(this);
        notifyObservers();
    }
    @Override
    public void quack() {
        System.out.println("Duck quacking");
    }

    @Override
    public void registerObserver(Observer observer) {
        quackObserver.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackObserver.notifyObservers();
    }

    public String toString() {
        return "Normal Duck";
    }
}
