public class Nothing  extends  EnemyClassDecorator{

    public Nothing(Enemy c) {
        super(c);
    }

    @Override
    public void create(){
        super.create();
        System.out.print(" and he needs nothing else!!");
    }
}
