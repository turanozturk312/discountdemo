public class TieredDiscount implements Discount {
    private Double treshold;
    private Integer percentage;

    public Double getTreshold() {
        return treshold;
    }

    public void setTreshold(Double treshold) {
        this.treshold = treshold;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public boolean isApplicable(Cart cart) {
        Double totalAmount = cart.calculateRawAmount();
        return totalAmount > treshold;
    }

    public Double calculateDiscount(Cart cart) {
        Double totalAmount = cart.calculateRawAmount();
        return totalAmount / 100 * percentage;
    }
}
