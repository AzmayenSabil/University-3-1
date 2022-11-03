import java.util.List;

public class EmployeeIterator implements Iterator{
    int index;
    List<Employee> subordinates;

    EmployeeIterator (List<Employee> subordinates){
        this.subordinates = subordinates;
    }
    @Override
    public boolean hasNext() {
        if(index < subordinates.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return subordinates.get(index++);
        }
        return null;
    }
}
