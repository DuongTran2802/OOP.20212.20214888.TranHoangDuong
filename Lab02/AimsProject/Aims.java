public class Aims {
    public static void main(String[] args) {
        // create a new cart
        Cart anOrder = new Cart();

        // create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers", "Action", "Joss Whedon", 18.99f);
        anOrder.addDigitalVideoDisc(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Batman", "Action", "Matt Reeves", 21.95f);
        anOrder.addDigitalVideoDisc(dvd5);

        // print total cost of all items in the cart
        System.out.println("Total cost of all items in cart: " + cart.totalCost());


        // remove some items from the cart and print total cost of the remaining items in the cart
         System.out.println("Total cost of remaining items in cart: " + cart.totalCost());

        System.out.println("Quantity of " + dvd1.getTitle() + " in cart: " + cart.getQtyOrdered(dvd1));
        System.out.println("Quantity of " + dvd2.getTitle() + " in cart: " + cart.getQtyOrdered(dvd2));
        System.out.println("Quantity of " + dvd3.getTitle() + " in cart: " + cart.getQtyOrdered(dvd3));
        System.out.println("Quantity of " + dvd4.getTitle() + " in cart: " + cart.getQtyOrdered(dvd4));
        System.out.println("Quantity of " + dvd5.getTitle() + " in cart: " + cart.getQtyOrdered(dvd5));
    }
}
