package hust.soict.dsai.aims.screen.event_handle;

import javax.swing.JFrame;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

public class AddItemToStore extends JFrame {
    protected Store store;
    protected String type;

    public AddItemToStore(Store store, String mediaType) {
        this.store = store;
        this.type = mediaType;
    }

    public Store getUpdatedStore(Media media) {
        store.addMedia(media);
        return store;
    }
}
