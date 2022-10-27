import java.util.ArrayList;
import java.util.List;

public class Employee implements Container{
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    // constructor
    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
    }

    private class EmployeeIterator implements Iterator{
        int index;
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

    @Override
    public Iterator getIterator() {
        return new EmployeeIterator();
    }
}