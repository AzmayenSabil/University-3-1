public class CurlOfShapeDecorator extends ShapeDecorator{

    public CurlOfShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }

    @Override
    public String draw(){
        return setCurlyBorder(decoratedShape);
    }

    private String setCurlyBorder(Shape decoratedShape){
        return decoratedShape.draw() + " -- Border is of Curly Pattern";
    }
}
