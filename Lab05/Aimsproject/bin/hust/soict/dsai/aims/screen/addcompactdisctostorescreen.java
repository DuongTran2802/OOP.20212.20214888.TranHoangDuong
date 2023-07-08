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
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

import java.io.IOException;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStore {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "DVD");

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setTitle("Add Book");
        setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/addCD.fxml"));
                loader.setController(new AddCompactDiscToScreenController(store));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setSize(640, 480);
    }

    private class AddCompactDiscToScreenController {
        @FXML private TextField titleCD;
        @FXML private TextField authorCD;
        @FXML private TextField categoryCD;
        @FXML private TextField costCD;
        @FXML private TextField tracksCD;
        @FXML private Button btnAddCD;

        public AddCompactDiscToScreenController(Store store) {
            super();
            this.store = store;
        }
        @FXML
        private void intitialize() {
            btnAddCD.setVisible(true);
            titleCD.setVisible(true);
            authorCD.setVisible(true);
            categoryCD.setVisible(true);
            costCD.setVisible(true);
            tracksCD.setVisible(true);
        }
        @FXML
        private void btnAddCDPressed() {
            String title = titleCD.getText();
            String author = authorCD.getText();
            String category = categoryCD.getText();

            try {
                ArrayList<Track> trackListCD = new ArrayList<>();

                Float cost = Float.parseFloat(costCD.getText());
                String[] tracks = tracksCD.getText().split(", ");
                int length = 0;
                for (int i = 0; i <= tracks.length - 1; i += 2) {
                    String trackTitle = tracks[i];
                    int trackLength = Integer.parseInt(tracks[i + 1].replace(" ", ""));
                    if (trackLength <= 0) {
                        throw new IllegalArgumentException();
                    }
                    length += trackLength;
                    trackListCD.add(new Track(trackTitle, trackLength));
                }
                int currID = store.getItemsInStore().size() + 1;
                CompactDisc cd = new CompactDisc(currID, title, category, length, author, cost);
                for (Track t : trackListCD) {
                    cd.addTrack(t);
                }
                store.addMedia(cd);
                setVisible(false);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Error: Wrong format of input");
            }
        }
    }
}
