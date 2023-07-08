package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createMenuBar());
        northPanel.add(createHeader());
        return northPanel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenu updateStoreSubMenu = new JMenu("Update Store");

        updateStoreSubMenu.add(new JMenuItem("Add Book"));
        updateStoreSubMenu.add(new JMenuItem("Add CD"));
        updateStoreSubMenu.add(new JMenuItem("Add DVD"));

        optionsMenu.add(updateStoreSubMenu);
        optionsMenu.add(new JMenuItem("View store"));
        optionsMenu.add(new JMenuItem("View cart"));
        menuBar.add(optionsMenu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        JButton viewCartButton = new JButton("View cart");
        viewCartButton.setPreferredSize(new Dimension(100, 50));
        viewCartButton.setMaximumSize(new Dimension(100, 50));
        viewCartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CartScreen(cart, store);
                setVisible(false);
            }
        });

        headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(viewCartButton);
        headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        return headerPanel;
    }

    private JPanel createCenter() {
        JPanel centerPanel = new JPanel(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            Media media = (i < mediaInStore.size()) ? mediaInStore.get(i) : new Media() {};
            centerPanel.add(new MediaStore(media, cart));
        }
        return centerPanel;
    }
}
