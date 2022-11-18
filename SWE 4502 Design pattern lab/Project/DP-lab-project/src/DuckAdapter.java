public class DuckAdapter implements QuackBehaviour{

    Goose goose;
    QuackObserver quackObserver;

    public DuckAdapter(Goose goose){
        this.goose = goose;
        quackObserver = new QuackObserver(this);
        notifyObservers();
    }
    @Override
    public void quack() {
        System.out.print("I am a different duck --- ");
        goose.honk();
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
        return "Pretending to be a duck";
    }

}
