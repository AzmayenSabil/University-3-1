public class QuackCounterFactory extends DuckUtilsFactory{
    public QuackCounter getCounterFactory(String counterFactory, QuackBehaviour duck){
        if(counterFactory.equalsIgnoreCase("count")){
            return new QuackCounter(duck);
        }else{
            return null;
        }
    }

    public QuackBehaviour getFactory(String duckFactory){
        return null;
    }
}
