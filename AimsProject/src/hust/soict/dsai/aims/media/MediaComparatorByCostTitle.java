/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getCost() > media2.getCost()) {
            return -1; // media1 is ranked higher
        } else if (media1.getCost() < media2.getCost()) {
            return 1; // media2 is ranked higher
        } else {
            // If the cost is the same, compare the title alphabetically
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
