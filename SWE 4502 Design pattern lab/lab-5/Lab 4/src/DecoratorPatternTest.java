public class DecoratorPatternTest {

    public static void main(String[] args) {
//        Enemy swordsman = new Swords(new Pikeman());
//        swordsman.create();
//        System.out.println("\n*****");
//
//        Enemy swordNshield = new Shield(new Swords(new Pikeman()));
//        swordNshield.create();
//        System.out.println("\n*****");
//
////        Enemy e = new Pikeman();

        EnemyDecoratingFactory factory = new EnemyDecoratingFactory();
        EnemyFactory enemyFactory = new EnemyFactory();



        Enemy e = factory.addShields(enemyFactory.createElement());
        e.create();
        System.out.println("\n*****");

        e = factory.addSwords(e);
        e.create();
    }

}