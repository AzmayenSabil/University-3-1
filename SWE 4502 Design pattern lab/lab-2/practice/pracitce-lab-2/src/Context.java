public class Context {
    int amountOfDiscount;
    Discount discountType;

    public Context(Discount discountType, int amountOfDiscount){
        this.discountType = discountType;
        this.amountOfDiscount = amountOfDiscount;
    }

    public void giveDiscount(){
        discountType.getDiscount(amountOfDiscount);
    }
}
