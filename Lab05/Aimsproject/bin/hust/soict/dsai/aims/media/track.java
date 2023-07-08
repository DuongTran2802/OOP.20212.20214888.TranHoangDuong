package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public String play() throws PlayerException {
        if (length > 0) {
            return "Playing track: " + title + "\n" + "Track Length: " + length;
        } else {
            System.err.println("Error: Track length is non-positive");
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }
    public boolean equals(Object o) {
        if (o instanceof Track) {
            Track t = (Track) o;
            return title.equals(t.getTitle()) && length == t.getLength();
        } else {
            return false;
        }
    }
}
