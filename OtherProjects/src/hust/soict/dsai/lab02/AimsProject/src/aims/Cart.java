/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.lab02.AimsProject.src.aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int quantityOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
//        Check the cart is already full or not
        if (quantityOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }

        this.itemsOrdered[this.quantityOrdered++] = disc;
        System.out.printf("The disc %s has been added.\n", disc.getTitle());
    }

//    2.1. Method overloading accepts a list of DVDs
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        if (quantityOrdered >= MAX_NUMBERS_ORDERED) {
//            System.out.println("The cart is full.");
//            return;
//        }
//
//        for (DigitalVideoDisc disc : dvdList) {
//            if (quantityOrdered < MAX_NUMBERS_ORDERED) {
//                this.itemsOrdered[this.quantityOrdered++] = disc;
//                System.out.printf("The disc %s has been added.\n", disc.getTitle());
//            } else {
//                System.out.printf("The disc %s cannot be added.\n", disc.getTitle());
//                break;
//            }
//        }
//    }

    // 2.1. Method overloading accepts an arbitrary number of DVDs (varargs)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (quantityOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }

        for (DigitalVideoDisc disc : dvdList) {
            if (quantityOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[this.quantityOrdered++] = disc;
                System.out.printf("The disc %s has been added.\n", disc.getTitle());
            } else {
                System.out.printf("The disc %s cannot be added.\n", disc.getTitle());
                break;
            }
        }
    }

    // 2.2. Method overloading accepts 2 DVDs as arguments
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (quantityOrdered < MAX_NUMBERS_ORDERED - 1) {
            this.itemsOrdered[this.quantityOrdered++] = dvd1;
            this.itemsOrdered[this.quantityOrdered++] = dvd2;

            System.out.printf("The disc %s has been added.\n", dvd1.getTitle());
            System.out.printf("The disc %s has been added.\n", dvd2.getTitle());
        } else if (quantityOrdered < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered[this.quantityOrdered++] = dvd1;

            System.out.printf("The disc %s has been added.\n", dvd1.getTitle());
            System.out.printf("The disc %s cannot be added.\n", dvd2.getTitle());
        } else {
            System.out.println("The cart is full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantityOrdered == 0) {
            System.out.println("The cart is empty.");
            return;
        }

        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < quantityOrdered - 1; j++)
                    itemsOrdered[j] = itemsOrdered[j + 1];
                itemsOrdered[--quantityOrdered] = null;
                break;
            }
        }

        System.out.printf("The disc %s has been removed.\n", disc.getTitle());
    }

    public float totalCost() {
        float cost = 0;

        for (int i = 0; i < quantityOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}
