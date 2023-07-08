package hust.soict.dsai.aims.media;
import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public boolean addAuthor(String authorName) {
        return authors.add(authorName);
    }

    public String toString() {
        return "Book " + super.toString();
    }

    public boolean removeAuthor(String authorName) {
        return authors.remove(authorName);
    }
}
