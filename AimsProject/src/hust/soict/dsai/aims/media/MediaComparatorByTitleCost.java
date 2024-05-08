/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
            return Float.compare(o2.getCost(), o1.getCost());
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

}
