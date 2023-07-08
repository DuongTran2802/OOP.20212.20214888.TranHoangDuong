package hust.soict.dsai.aims.media;
import java.util.*;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, length, author, cost);
    }	    

    public boolean addTrack(Track track) {
        return tracks.add(track);
    }
    public boolean removeTrack(Track track) {
        return tracks.remove(track);
    }

    public int getLength() {
        int total_length = 0;
        for (Track track : tracks) {
            total_length += track.getLength();
        }
        return total_length;
    }

    public String toString() {
        return "CD by " + artist + super.toString();
    }

    public String play() throws PlayerException {
        if (getLength() > 0) {
            StringBuilder playing = new StringBuilder();
            for (Track track : tracks) {
                try {
                    playing.append(track.play()).append('\n');
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return playing.toString();
        } else {
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }
}
