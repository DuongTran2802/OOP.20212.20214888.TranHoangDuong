package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public boolean addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m);
            return true;
        } else {
            throw new LimitExceededException();
        }
    }

    public boolean removeMedia(Media m) {
        return itemsOrdered.remove(m);
    }

    public void sortCostTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));
    }

    public void sortTitleCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle).thenComparing(Media::getCost));
    }

    public float totalCost() {
        return itemsOrdered.stream().map(Media::getCost).reduce(0f, Float::sum);
    }

    public Media searchID(int id) {
        return itemsOrdered.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public Media searchTitle(String title) {
        return itemsOrdered.stream().filter(item -> item.getTitle().equals(title)).findFirst().orElse(null);
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void print() {
        System.out.println("*".repeat(15) + "CART" + "*".repeat(15));
        itemsOrdered.stream().sorted(Comparator.comparing(Media::getId)).forEach(System.out::println);
        System.out.println("*".repeat(34));
    }
}
