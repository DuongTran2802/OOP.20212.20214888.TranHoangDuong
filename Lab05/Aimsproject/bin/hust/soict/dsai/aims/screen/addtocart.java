package hust.soict.dsai.aims.screen.event_handle;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import java.awt.*;

public class AddToCart extends JDialog {
    private Media media;
    private Cart cart;

    public AddToCart(Media media, Cart cart) throws LimitExceededException {
        super();
        this.media = media;
        this.cart = cart;

        try {
            this.cart.addMedia(this.media);
            showMessage("Add to cart successfully");
        } catch (LimitExceededException e) {
            showMessage("You reach the maximum load of cart");
        }
    }
    private void showMessage(String message) {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        cp.add(new JLabel(message));

        setTitle("Added to cart");
        setSize(300, 100);
        setVisible(true);
    }
    public Cart getUpdatedCart() {
        return this.cart;
    }
}
