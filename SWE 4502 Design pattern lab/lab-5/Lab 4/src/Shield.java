public class Shield extends EnemyClassDecorator {

    public Shield(Enemy c) {
        super(c);
    }

    @Override
    public void create(){
        super.create();
        System.out.print(" and shields");
    }
}