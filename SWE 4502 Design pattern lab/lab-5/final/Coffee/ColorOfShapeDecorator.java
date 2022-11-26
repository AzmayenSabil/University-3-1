public class ColorOfShapeDecorator extends ShapeDecorator{

    public ColorOfShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public String draw(){
        return setColor(decoratedShape);
    }

    private String setColor(Shape decoratedShape){
        return decoratedShape.draw() + " -- with color";
    }

}
