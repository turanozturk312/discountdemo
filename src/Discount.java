public interface Discount {
    public boolean isApplicable(Cart cart);

    public Double calculateDiscount(Cart cart);

}
