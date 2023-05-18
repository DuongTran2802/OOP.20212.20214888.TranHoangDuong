package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");

        swapDVDs(dvd1, dvd2);
        System.out.println("dvd1 title: " + dvd1.getTitle());
        System.out.println("dvd2 title: " + dvd2.getTitle());

        changeDVDTitle(dvd1, dvd2.getTitle());
        System.out.println("dvd1 title: " + dvd1.getTitle());
    }

    public static void swapDVDs(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        String tempTitle = disc1.getTitle();
        disc1.setTitle(disc2.getTitle());
        disc2.setTitle(tempTitle);
    }

    public static void changeDVDTitle(DigitalVideoDisc disc, String newTitle) {
        disc.setTitle(newTitle);
    }
}

