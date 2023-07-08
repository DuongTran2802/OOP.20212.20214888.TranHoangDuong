package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();
    public boolean addMedia(Media m){
        return itemsInStore.add(m);
    }
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
    public boolean removeMedia(Media m) {
        return itemsInStore.remove(m);
    }
    public int searchMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)){
                return m.getId();
            }
        }
        return -1;
    }
    public Media detailsId(int id) {
        for (Media m : itemsInStore) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
    public Store() {
        super();
    }
}
