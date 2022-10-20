import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = Arrays.asList(new PancakeHouseMenu(), new DinerMenu(), new CafeMenu());
        Waitress waitress = new Waitress(menus);

        waitress.printMenu();
    }
}
