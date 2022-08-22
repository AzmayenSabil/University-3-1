public class EidDiscount implements Discount{
    int amountOfDiscount;
    @Override
    public void getDiscount(int amountOfDiscount) {
        this.amountOfDiscount = amountOfDiscount;
        System.out.println("Amount of Discount for Eid: "+ amountOfDiscount);
    }
}
