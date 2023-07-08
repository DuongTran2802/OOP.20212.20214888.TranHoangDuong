package hust.soict.dsai.aims.screen.event_handle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.io.IOException;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStore {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "DVD");

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setTitle("Add Book");
        setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/addDVD.fxml"));
                loader.setController(new AddDigitalVideoDiscToScreenController(store));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setSize(640, 480);
    }
    private class AddDigitalVideoDiscToScreenController {
        @FXML private TextField titleDVD;
        @FXML private TextField authorDVD;
        @FXML private TextField categoryDVD;
        @FXML private TextField costDVD;
        @FXML private TextField lengthDVD;
        @FXML private Button btnAddDVD;

        public AddDigitalVideoDiscToScreenController(Store store) {
            super();
            this.store = store;
        }
        @FXML
        private void intitialize() {
            btnAddDVD.setVisible(true);
            titleDVD.setVisible(true);
            authorDVD.setVisible(true);
            categoryDVD.setVisible(true);
            costDVD.setVisible(true);
            lengthDVD.setVisible(true);
        }
        @FXML
        private void btnAddDVDPressed() {
            String title = titleDVD.getText();
            String author = authorDVD.getText();
            String category = categoryDVD.getText();
            try {
                float cost = Float.parseFloat(costDVD.getText());
                if (cost <= 0.0) {
                    throw new IllegalArgumentException();
                }
                int length = Integer.parseInt(lengthDVD.getText());
                if (length <= 0) {
                    throw new IllegalArgumentException();
                }
                int currID = store.getItemsInStore().size() + 1;
                store.addMedia(new DigitalVideoDisc(currID, title, category, length, author, cost));
                setVisible(false);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Error: Wrong format of input");
            }
        }
    }
}
