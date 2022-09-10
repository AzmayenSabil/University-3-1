public class Database {
    //used for singleton example
    private static Database dbObject = new Database();

    private Database(){}

    public static Database getInstance(){
        return dbObject;
    }

    public void establishConnection(){
        System.out.println("Database Connected from main databse class");
    }

}
