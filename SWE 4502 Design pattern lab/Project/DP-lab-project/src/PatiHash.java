public class PatiHash implements QuackBehaviour {

    QuackObserver quackObserver;

    public PatiHash(){
        quackObserver = new QuackObserver(this);
        notifyObservers();
    }
    @Override
    public void quack() {
        System.out.println("Patihash quacking");
        this.notifyObservers();
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
        return "Patihash";
    }

}
