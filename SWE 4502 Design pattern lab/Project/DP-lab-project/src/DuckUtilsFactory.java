public abstract class DuckUtilsFactory {
    abstract QuackBehaviour getFactory(String duckFactory);
    abstract QuackBehaviour getCounterFactory(String counterFactory, QuackBehaviour duck);
}
