/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;

    public Disc(String title, int length) {
        super(title);
        this.length = length;
    }

    public Disc(String title, String category, int length) {
        super(title, category);
        this.length = length;
    }

    public Disc(String title, String category, float cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
