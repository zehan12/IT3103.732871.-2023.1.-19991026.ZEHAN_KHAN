/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

public class DigitalVideoDiscWrapper {
    private DigitalVideoDisc dvd;

    public DigitalVideoDiscWrapper(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }

    public DigitalVideoDisc getDVD() {
        return dvd;
    }

    public void setDVD(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}
