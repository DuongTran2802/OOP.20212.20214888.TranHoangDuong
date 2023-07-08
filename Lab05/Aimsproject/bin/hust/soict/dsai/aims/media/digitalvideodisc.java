package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {

    public DigitalVideoDisc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, length, author, cost);
    }

    public String play() throws PlayerException {
        if (getLength() > 0) {
            return "Playing DVD: " + getTitle() + "\n DVD Length: " + getLength();
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
}
