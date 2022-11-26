public class EnemyClassDecorator implements Enemy {

    protected Enemy car;

    public EnemyClassDecorator(Enemy c){
        this.car=c;
    }

    @Override
    public void create() {
        this.car.create();
    }

}