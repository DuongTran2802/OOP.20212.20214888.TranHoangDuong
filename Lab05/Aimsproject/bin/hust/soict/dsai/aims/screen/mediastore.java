package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel costLabel = new JLabel(media.getCost() + "$");
        costLabel.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart.addToCart(media);
            }
        });
        container.add(addToCartButton);

        if (media instanceof hust.soict.dsai.aims.media.Playable) {
            JButton playButton = new JButton("Play");
            playButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ((hust.soict.dsai.aims.media.Playable) media).play();
                }
            });
            container.add(playButton);
        }

        add(Box.createVerticalGlue());
        add(titleLabel);
        add(costLabel);
        add(Box.createVerticalGlue());
        add(container);
    }
}

