public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addDigitalVideoDisc(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        cart.addDigitalVideoDisc(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        cart.addDigitalVideoDisc(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        cart.print();

        cart.search(2);
        cart.search("The Lion King");
    }
}
