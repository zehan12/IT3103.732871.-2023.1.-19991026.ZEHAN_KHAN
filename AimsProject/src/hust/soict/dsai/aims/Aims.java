/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static final Store store = new Store(100);
    private static final Cart cart = new Cart();
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
    }

    public static void main(String[] args) {
        try {

            CompactDisc cd1 = new CompactDisc(
                    "folklore",
                    "Pop",
                    19.69f,
                    67,
                    "Taylor Swift");
            CompactDisc cd2 = new CompactDisc(
                    "reputation",
                    "Pop",
                    22.57f,
                    56,
                    "Taylor Swift");
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    "Folklore: The Long Pond Studio Sessions",
                    "Documentary",
                    22.57f,
                    106,
                    "Taylor Swift");
            Book book = new Book(
                    "The Hunger Games",
                    "Science fiction",
                    10.99f);
            store.addMedia(cd1, cd2, dvd, book);
        } catch (Exception e) {
        }

        openStoreScreen();
    }
}
