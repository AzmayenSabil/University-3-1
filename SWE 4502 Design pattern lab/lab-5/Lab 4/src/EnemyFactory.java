public class EnemyFactory extends AbstractFactory {

    @Override
    public Enemy createElement() {
            return new Pikeman();
    }
}
