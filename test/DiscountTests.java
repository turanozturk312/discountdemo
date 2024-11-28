import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DiscountTests {

    @Test
    public void getTotalCountWhenValidItemsGiven() {
        //Given
        Cart cart = getCart();

        //When
        Double totalPrice = cart.calculateTotalAmount();

        //Then
        Assertions.assertEquals(1000.0, totalPrice);
    }

    @Test
    public void noTieredDiscountUnder100DollarsOfTotalPrice() {
        // given
        Cart cart = new Cart();
        Item item1 = new Item("Computer", 30.0);
        Item item2 = new Item("Television", 20.0);
        Item item3 = new Item("Cleaner", 5.0);
        User user = new User("turanozt");
        cart.setItems(List.of(item1, item2, item3));
        cart.setUser(user);

        TieredDiscount tieredDiscount = new TieredDiscount();
        tieredDiscount.setTreshold(100.0);
        tieredDiscount.setPercentage(5);
        cart.setDiscounts(List.of(tieredDiscount));
        // when

        Double totalAmount = cart.calculateTotalAmount();

        // theN
        Assertions.assertEquals(55.0, totalAmount);
    }

    @Test
    public void makeTieredDiscountWhenOver100DollarsTotalPrice() {
        //Given
        Cart cart = getCart();
        TieredDiscount tieredDiscount = new TieredDiscount();
        tieredDiscount.setTreshold(100.0);
        tieredDiscount.setPercentage(5);
        cart.setDiscounts(List.of(tieredDiscount));

        //When
        Double totalCount = cart.calculateTotalAmount();

        //Then
        Assertions.assertEquals(950.0, totalCount);
    }

    private static Cart getCart() {
        Item item1 = new Item("Computer", 600.0);
        Item item2 = new Item("Television", 300.0);
        Item item3 = new Item("Cleaner", 100.0);
        User user = new User("turanozt");
        Cart cart = new Cart();
        cart.setItems(List.of(item1, item2, item3));
        cart.setUser(user);
        return cart;
    }
}
