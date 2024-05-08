/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.lab02.AimsProject.src.aims;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f);

        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.printf("Total cost is: %f\n", anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.printf("Total cost is: %f\n", anOrder.totalCost());
    }
}
