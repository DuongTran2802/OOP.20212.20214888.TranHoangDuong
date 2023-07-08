package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.*;
import javafx.collections.transformation.FilteredList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.event_handle.*;

public class CartScreenController {
    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private TextField tfTotalCost
    @FXML private Button btnPlaceOrder;

    private Cart cart;
    private Store store;
    private float totalCost;

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
        totalCost = cart.totalCost();
    }
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        btnPlaceOrder.setVisible(true);

        tblMedia.setItems(cart.getItemsOrdered());

        tblMedia.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Media> observable, Media oldValue, Media newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            showFilteredMedia(newValue);
        });

        tfTotalCost.setText(totalCost + "");
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost = cart.totalCost();
        tfTotalCost.setText(totalCost + "");
    }
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            Playable disc = (Playable) media;
            new PlayMedia(disc);
        }
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.clear();
        totalCost = cart.totalCost();
        tfTotalCost.setText(totalCost + "");
    }
    @FXML
    void menuItemAddBookPressed(ActionEvent event) {
        new AddBookToStoreScreen(store);
    }
    @FXML
    void menuItemAddCDPressed(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store);
    }
    @FXML
    void menuItemAddDVDPressed(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store);
    }
    @FXML
    void menuItemViewStorePressed(ActionEvent event) {
        new StoreScreen(store, cart);
    }
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }
    void showFilteredMedia(String newValue) {
        String valueType = radioBtnFilterID.isSelected() ? "id" : "title";

        FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), media -> media.filterByProperty(newValue, valueType));

        tblMedia.setItems(list);
    }
}
