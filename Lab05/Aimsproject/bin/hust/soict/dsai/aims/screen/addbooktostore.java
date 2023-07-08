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
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import java.io.IOException;
public class AddBookToStoreScreen extends AddItemToStore {
    public AddBookToStoreScreen(Store store) {
        super(store, "Book");

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setTitle("Add Book");
        setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/addBook.fxml"));
                loader.setController(new AddBookToScreenController(store));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        setSize(640, 480);
    }

    public Store getUpdatedStore() {
        return store;
    }
    private class AddBookToScreenController {
        @FXML private TextField titleBook;
        @FXML private TextField authorsBook;
        @FXML private TextField categoryBook;
        @FXML private TextField costBook;
        @FXML private Button btnAddBook;

        public AddBookToScreenController(Store store) {
            super();
            this.store = store;
        }
        @FXML
        private void intitialize() {
            btnAddBook.setVisible(true);
            titleBook.setVisible(true);
            authorsBook.setVisible(true);
            categoryBook.setVisible(true);
            costBook.setVisible(true);
        }
        @FXML
        private void btnAddBookPressed() {
            String title = titleBook.getText();
            String[] authors = authorsBook.getText().split(",");
            String category = categoryBook.getText();
            try {
                Float cost = Float.parseFloat(costBook.getText());
                if (cost >= 0.0) {
                    Integer curr_id = store.getItemsInStore().size() + 1;
                    Book book = new Book(curr_id, title, category, cost);
                    for (String author : authors) {
                        book.addAuthor(author);
                    }
                    store.addMedia(book);
                    setVisible(false);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Only positive float cost accepted");
            }
        }
    }
}
