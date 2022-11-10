public abstract class DuckUtilsFactory {
    abstract QuackBehaviour getFactory(String duckFactory);
    abstract QuackCounter getCounterFactory(String counterFactory, QuackBehaviour duck);
}
