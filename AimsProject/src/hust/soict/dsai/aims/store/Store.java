/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since November 2023
 */

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    private static final int DEFAULT_CAPACITY = 20;

    private final ObservableList<Media> itemsInStore = FXCollections.observableArrayList();
    private int capacity;

    public Store() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public Store(int capacity) {
        this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
    }

    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media... medias) throws Exception {
        for (Media media : medias) {
            if (itemsInStore.size() < capacity) {
                if (itemsInStore.contains(media)) {
                    System.out.printf("The media %s already exist\n", media.getTitle());
                    throw new Exception("Media already exist");
                }

                itemsInStore.add(media);
                System.out.println("Media added to the store: " + media.getTitle());
            } else {
                System.out.println("Store is full. Cannot add more medias.");
                throw new LimitExceededException("Store is full");
            }
        }
    }

    public void removeMedia(String... titles) {
        for (String title : titles) {
            for (Media item : itemsInStore) {
                if (item.getTitle().equals(title)) {
                    System.out.println("Media removed from the store: " + title);
                    itemsInStore.remove(item);
                    break;
                }
            }
        }
    }

    public void removeMedia(Media... medias) {
        for (Media media : medias) {
            if (itemsInStore.contains(media)) {
                itemsInStore.remove(media);
                System.out.println("Media removed!");
            } else {
                System.out.println("Media does not exist!");
            }
        }
    }

    public void print() {
        System.out.println("\n*********************** STORE ***********************");
        System.out.println("Items in the store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemsInStore.get(i).toString());
        }
        System.out.println("*****************************************************\n");
    }
}
