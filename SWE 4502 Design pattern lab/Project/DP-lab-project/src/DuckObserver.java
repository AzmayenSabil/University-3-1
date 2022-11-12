 public class DuckObserver implements Observer {
    public void update(QuackObservable duck) {
        System.out.println("Duck Observer : " + duck + " just quacked.");
    }
}
