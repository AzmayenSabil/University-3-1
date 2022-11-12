public class QuackCounterFactory extends DuckUtilsFactory{
    public QuackBehaviour getCounterFactory(String counterFactory, QuackBehaviour duck){
        if(counterFactory.equalsIgnoreCase("count")){
            return new QuackCounter(duck);
        }else if(counterFactory.equalsIgnoreCase("countMany")){
            return new QuackCounterFlock(duck);
        }else{
            return null;
        }
    }

    public QuackBehaviour getFactory(String duckFactory){
        return null;
    }
}
