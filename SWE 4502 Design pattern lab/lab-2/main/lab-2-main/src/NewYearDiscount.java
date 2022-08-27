public class NewYearDiscount implements Discount{
    int amountOfDiscount;
    @Override
    public void getDiscount(int amountOfDiscount) {
        System.out.println("Discount for New Years eve is "+ amountOfDiscount + "% .");
    }
}
