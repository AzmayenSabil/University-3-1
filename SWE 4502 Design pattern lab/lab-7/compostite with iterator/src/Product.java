public abstract class Product implements Box{
    protected final String title;
    protected final double price;

    public Product(String title1, double price1) {
        this.title = title1;
        this.price = price1;
    }
}
