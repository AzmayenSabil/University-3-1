public class Context {
    int amountOfDiscount;
    Discount discount;

    public Context(Discount discount, int amountOfDiscount){
        this.discount = discount;
        this.amountOfDiscount = amountOfDiscount;
    }

    public void giveDiscount(){
        discount.getDiscount(amountOfDiscount);
    }
}
