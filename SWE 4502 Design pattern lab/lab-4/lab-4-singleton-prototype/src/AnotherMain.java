public class AnotherMain {
    //used for singleton example
    Database dbObject = Database.getInstance();

    public AnotherMain(){
        dbObject.establishConnection();
    }

}
