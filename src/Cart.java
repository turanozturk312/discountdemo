import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private User user;
    private List<Discount> discounts = new ArrayList<>();

    public Cart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Double calculateRawAmount() {
        Double total = 0.0;
        for (Item item : items) {
            total = total + item.getPrice();
        }

        return total;
    }

    public Double calculateTotalAmount() {
        Double total = Double.valueOf(calculateRawAmount());
        for (Discount discount : discounts) {
            if(discount.isApplicable(this)) {
                Double discountAmount = discount.calculateDiscount(this);
                total = total - discountAmount;
            }
        }
        return total;
    }
}
