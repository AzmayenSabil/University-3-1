import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FlockOfDucks implements QuackBehaviour{
    private QuackBehaviour duck;
    //private ArrayList<QuackBehaviour> ducks;
    List<QuackBehaviour> ducks = new ArrayList<QuackBehaviour>();

    // constructor
    public FlockOfDucks(QuackBehaviour duck) {
        this.add(duck);
    }

    public void add(QuackBehaviour e) {
        ducks.add(e);
    }

    public void remove(QuackBehaviour e) {
        ducks.remove(e);
    }
    public List<QuackBehaviour> getDucks(){
        return ducks;
    }

    public String toString(){
        duck.quack();
        return "successful";
    }

    @Override
    public void quack() {
        Iterator<QuackBehaviour> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            QuackBehaviour duck = (QuackBehaviour) iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<QuackBehaviour> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            QuackBehaviour duck = (QuackBehaviour) iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator<QuackBehaviour> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            QuackBehaviour duck = (QuackBehaviour) iterator.next();
            duck.notifyObservers();
        }
    }
}
