public class QuackCounter implements QuackBehaviour {

    QuackBehaviour duck;
    int numberOfQuacks = 0;

    public QuackCounter(QuackBehaviour duck){
        this.duck = duck;
    }

    @Override
    public void quack() {
        numberOfQuacks++;
        duck.quack();
    }

    public void getNumberOfQuacks(){
        System.out.println("Number of Quacks : " + numberOfQuacks);;
    }
}
