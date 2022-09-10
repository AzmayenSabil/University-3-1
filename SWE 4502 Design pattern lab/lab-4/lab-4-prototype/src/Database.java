import java.util.ArrayList;
import java.util.List;

public class Database implements Clone{

    private List<String> dbList;

    public Database(){
        dbList = new ArrayList<String>();
    }
    public Database(List<String> list){
        this.dbList = list;
    }

    public void loadData(){
        dbList.add("Sabil");
        dbList.add("Akshar");
        dbList.add("Tali");
        dbList.add("Barshat");
        dbList.add("Yeaken");
    }
    public List<String> getDbList(){
        return dbList;
    }

    @Override
    public Object clone() {
        List<String> tempDbList = new ArrayList<String>();
        for(String person: this.getDbList()){
            tempDbList.add(person);
        }
        return new Database(tempDbList);
    }
}
