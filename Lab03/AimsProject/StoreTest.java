package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();
    
        // Test the addDVD method
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Action", "Christopher Nolan", 148, 14.99f);
		store.addDVD(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 9.99f);
		store.addDVD(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 12.99f);
		store.addDVD(dvd3);
        store.print();

        // Test the removeDVD method
        System.out.println();
        store.removeDVD(dvd3);
        store.removeDVD(dvd1);
        store.print();
    }
}
