public abstract class ShapeDecorator implements Shape{ // Abstract Decorator class implementing interface

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public String draw(){
        return decoratedShape.draw(); //Interface object method call
    }
}
