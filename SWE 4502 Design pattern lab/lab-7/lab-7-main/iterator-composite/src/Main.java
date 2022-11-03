public class Main {
    public static void main(String[] args) {
        Employee CEO = new Employee("Muti","CEO", 150000);
        Employee headSales = new Employee("raiyan","Head Sales", 70000);
        Employee headMarketing = new Employee("Mehesum","Head Marketing", 50000);
        Employee salesPerson = new Employee("Rifat","Marketing", 25000);

        CEO.add(headSales);
        CEO.add(headMarketing);
        CEO.add(salesPerson);

        Employee GM = new Employee("sabil","marketing", 150000);
        Employee AGM = new Employee("Abir","marketing", 70000);
        Employee DGM = new Employee("Tali","Head Marketing", 50000);

        GM.add(AGM);
        GM.add(DGM);


        for(Iterator iter = CEO.getIterator(); iter.hasNext();){
            System.out.println(iter.next().toString());
        }

        System.out.println();

        for(Iterator iter = GM.getIterator(); iter.hasNext();){
            System.out.println(iter.next().toString());
        }
    }
}