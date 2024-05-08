/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;

    public DigitalVideoDisc(String title, int length, String director) {
        super(title, length);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, int length, String director) {
        super(title, category, length);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "DVD [" + this.getId() + "]"
                + " - " + this.getTitle()
                + " - " + this.getCategory()
                + " - " + this.getDirector()
                + " - " + this.getLength()
                + " - " + this.getCost() + "$";
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("DVD Title : " + this.getTitle());
            System.out.println("Length    : " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
