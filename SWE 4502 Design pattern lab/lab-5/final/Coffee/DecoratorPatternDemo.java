public class DecoratorPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("CIRCLE");
        System.out.println(circle.draw());

        Shape rectangle = shapeFactory.getShape("Rectangle");
        System.out.println(rectangle.draw());

        Shape curlyCircle = new CurlOfShapeDecorator(shapeFactory.getShape("CIRCLE"));
        System.out.println(curlyCircle.draw());

        Shape curlyRectangle = new CurlOfShapeDecorator(shapeFactory.getShape("Rectangle"));
        System.out.println(curlyRectangle.draw());

        Shape coloredCircle = new ColorOfShapeDecorator(shapeFactory.getShape("CIRCLE"));
        System.out.println(coloredCircle.draw());

        Shape colorRectangle = new ColorOfShapeDecorator(shapeFactory.getShape("Rectangle"));
        System.out.println(colorRectangle.draw());

        Shape coloredAndCurlyCircle = new ColorOfShapeDecorator(curlyCircle);
        System.out.println(coloredAndCurlyCircle.draw());

        Shape colorAndCurlyRectangle = new ColorOfShapeDecorator(curlyRectangle);
        System.out.println(colorAndCurlyRectangle.draw());

    }
}
