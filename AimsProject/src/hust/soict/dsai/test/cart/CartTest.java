/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since November 2023
 */

package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                19.95f,
                87,
                "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                24.95f,
                124,
                "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                18.99f,
                90,
                "John Musker");

        cart.addMedia(dvd1, dvd2, dvd3);

//        Test the print method
        cart.print();

//        Test the search methods
        cart.search(1);
        cart.search("Aladin");
        cart.search("Cinderella");
    }
}