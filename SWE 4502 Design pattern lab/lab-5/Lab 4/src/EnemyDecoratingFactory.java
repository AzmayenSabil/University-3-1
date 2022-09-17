public class EnemyDecoratingFactory extends AbstractFactory{

    public EnemyClassDecorator createElement() {
        return new Nothing(new Pikeman());
    }

    public static Enemy addSwords(Enemy thing){
        return new Swords(thing);
    }

    public static Enemy addShields(Enemy thing){
        return new Shield(thing);
    }
}
