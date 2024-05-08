/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private final FloatProperty totalCost = new SimpleFloatProperty(0);

    public Cart() {
        itemsOrdered.addListener((ListChangeListener<Media>) change -> {
            updateTotalCost();
        });
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public float getTotalCost() {
        return totalCost.get();
    }

    public FloatProperty totalCostProperty() {
        return totalCost;
    }

    private void updateTotalCost() {
        float cost = 0;

        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        totalCost.set(cost);
    }

    public void addMedia(Media... medias) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }

        for (Media media : medias) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                if (itemsOrdered.contains(media)) {
                    System.out.printf("The media %s already exist\n", media.getTitle());
                    continue;
                }

                itemsOrdered.add(media);
                System.out.printf("The media %s has been added.\n", media.getTitle());
            } else {
                System.out.printf("The media %s cannot be added.\n", media.getTitle());
            }
        }
    }

    public void removeMedia(Media item) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Empty cart. Please add some items.");
            return;
        }
        System.out.printf("The media %s has been removed.\n", item.getTitle());
        itemsOrdered.remove(item);
    }

    public void removeMedia(int id) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Empty cart. Please add some items.");
            return;
        }
        if (id < itemsOrdered.size()) {
            System.out.printf("The media %s has been removed.\n", itemsOrdered.get(id).getTitle());
            itemsOrdered.remove(id);
        }
    }

    public float totalCost() {
        float cost = 0;

        for (Media item : itemsOrdered) {
            cost += item.getCost();
        }
        return cost;
    }

    public void print() {
        System.out.println("\n*********************** CART ***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("****************************************************\n");
    }

    public Media search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found the media:");
                System.out.println(media.toString());
                return media;
            }
        }
        System.out.println("Media not found!");
        return null;
    }

    public ArrayList<Media> search(String title) {
        ArrayList<Media> foundMedia = new ArrayList<>();

        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundMedia.add(media);
            }
        }

        if (!foundMedia.isEmpty()) {
            System.out.println("Found the media:");
            for (Media media : foundMedia) {
                System.out.println(media.toString());
            }
        } else {
            System.out.println("Media not found!");
        }

        return foundMedia;
    }

    public void sortByTitleCost() {
        this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}
