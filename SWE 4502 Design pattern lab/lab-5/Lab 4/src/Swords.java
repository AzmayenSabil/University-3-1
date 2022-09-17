public class Swords extends EnemyClassDecorator {

    public Swords(Enemy c) {
        super(c);
    }

    @Override
    public void create(){
        super.create();
        System.out.print(" and swords");
    }
}