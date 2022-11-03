public class DuckAdapter implements QuackBehaviour{

    Goose goose;

    public DuckAdapter(Goose goose){
        this.goose = goose;
    }
    @Override
    public void quack() {
        System.out.print("I am a different duck --- ");
        goose.honk();
    }
}
