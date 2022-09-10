import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.loadData();

        Database dbCopy = (Database) db.clone();
        List<String> dbCopyList = dbCopy.getDbList();
        dbCopyList.add("Abir");

        Database dbCopy2 = (Database) db.clone();
        List<String> dbCopyList2 = dbCopy2.getDbList();
        dbCopyList2.remove("Tali");

        System.out.println(db.getDbList());
        System.out.println(dbCopyList);
        System.out.println(dbCopyList2);
    }
}
