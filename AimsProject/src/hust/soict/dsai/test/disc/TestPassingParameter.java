/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.DigitalVideoDiscWrapper;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDiscWrapper jungleDVDWrapper = new DigitalVideoDiscWrapper(new DigitalVideoDisc("Jungle", 90, "John Musker"));
        DigitalVideoDiscWrapper cinderellaDVDWrapper = new DigitalVideoDiscWrapper(new DigitalVideoDisc("Cinderella", 90, "John Musker"));

        swap(jungleDVDWrapper, cinderellaDVDWrapper);
        System.out.println("jungle dvd title: " + jungleDVDWrapper.getDVD().getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVDWrapper.getDVD().getTitle());
    }

    public static void swap(DigitalVideoDiscWrapper wrapper1, DigitalVideoDiscWrapper wrapper2) {
        DigitalVideoDisc temp = wrapper1.getDVD();
        wrapper1.setDVD(wrapper2.getDVD());
        wrapper2.setDVD(temp);
    }
}
