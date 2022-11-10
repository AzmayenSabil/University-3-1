import java.util.ArrayList;
import java.util.List;

public class FlockOfDucks implements QuackBehaviour{
    private QuackBehaviour duck;
    private ArrayList<QuackBehaviour> ducks;

    // constructor
    public FlockOfDucks(QuackBehaviour duck) {
        this.duck = duck;
        ducks = new ArrayList<>();
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
        for (QuackBehaviour i : ducks) {
            //System.out.println("running");
            i.quack();
        }
    }
}
