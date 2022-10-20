public class Waitress {
    List<Menu> menus;

    public Waitress(List<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        System.out.println("Menus : ");

        menus.forEach(menu -> {
            System.out.println("===");
            printMenu(menu.createIterator());
        });
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
