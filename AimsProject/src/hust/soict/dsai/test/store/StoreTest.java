/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since November 2023
 */

package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        try {

            Store store = new Store(20);

            Media dvd1 = new DigitalVideoDisc(
                    "The Lion King",
                    "Animation",
                    19.95f,
                    87,
                    "Roger Allers");
            Media dvd2 = new DigitalVideoDisc(
                    "Star Wars",
                    "Science Fiction",
                    24.95f,
                    124,
                    "George Lucas");
            Media dvd3 = new DigitalVideoDisc(
                    "Aladdin",
                    "Animation",
                    18.99f,
                    90,
                    "John Musker");

            store.addMedia(dvd1, dvd2, dvd3);
            store.print();

            store.removeMedia("Aladin");
            store.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
