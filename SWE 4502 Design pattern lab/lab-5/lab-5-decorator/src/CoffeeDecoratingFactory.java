public class CoffeeDecoratingFactory {

    public CoffeeDecorator addMilk(Coffee coffee){
        return new WithMilk(coffee);
    }

    public CoffeeDecorator addSugar(Coffee coffee){
        return new WithSugar(coffee);
    }
}
