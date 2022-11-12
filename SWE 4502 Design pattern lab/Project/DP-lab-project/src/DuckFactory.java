public class DuckFactory extends DuckUtilsFactory{
    public QuackBehaviour getFactory(String duckFactory){
        if(duckFactory.equalsIgnoreCase("duck")){
            //System.out.println();
            System.out.println("DUCK created");
            return new Duck();
        }else if(duckFactory.equalsIgnoreCase("patihash")){
            //System.out.println();
            System.out.println("PATIHASH created");
            return new PatiHash();
        }else if(duckFactory.equalsIgnoreCase("goose")){
            //System.out.println();
            System.out.println("Goose created");
            return new DuckAdapter(new Goose());
        }
        return null;
    }

    public QuackCounter getCounterFactory(String counterFactory, QuackBehaviour duck){
        return null;
    }
}
