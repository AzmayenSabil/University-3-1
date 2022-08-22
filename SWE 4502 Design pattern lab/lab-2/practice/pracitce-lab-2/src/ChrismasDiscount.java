public class ChrismasDiscount implements Discount{
    int amountOfDiscount;
    @Override
    public void getDiscount(int amountOfDiscount) {
        this.amountOfDiscount = amountOfDiscount;
        System.out.println("Amount of Discount for Christmas: "+ amountOfDiscount);
    }
}
