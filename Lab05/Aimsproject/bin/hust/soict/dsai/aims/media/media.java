package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = (m1, m2) -> {
        int result = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (result == 0) {
            result = Float.compare(m1.getCost(), m2.getCost());
        }
        return result;
    };
     public static final Comparator<Media> COMPARE_BY_COST_TITLE = (m1, m2) -> {
        int result = Float.compare(m1.getCost(), m2.getCost());
        if (result == 0) {
            result = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        }
        return result;
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public String toString() {
        return "Id: " + id + ", Title: " + title + ", Category: " + category + ", Cost: " + cost;
    }

    public boolean equals(Object o) {
        if (o instanceof Media) {
            Media m = (Media) o;
            return this.getTitle().equals(m.getTitle());
        } else {
            return false;
        }
    }

    public boolean filterByProperty(String value, String filterType) {
        if (value == null || value.isEmpty()) {
            return true;
        } else {
            if (filterType.equals("title")) {
                return this.getTitle().toLowerCase().contains(value.toLowerCase());
            } else if (filterType.equals("id")) {
                return Integer.toString(this.getId()).toLowerCase().contains(value.toLowerCase());
            }
        }
        return false;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
    }
}
