public class EidDiscount implements Discount {
    int amountOfDiscount;
    @Override
    public void getDiscount(int amountOfDiscount) {
        System.out.println("Discount for eid is "+ amountOfDiscount + "% .");
    }
}
