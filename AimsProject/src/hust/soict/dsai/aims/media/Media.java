/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
    private static int nbMedias = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title) {
        this.title = title;
        this.id = ++nbMedias;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedias;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedias;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Media media)) {
            return false;
        }
        return this.title.equals(media.title);
    }

    @Override
    public String toString() {
        return "Media [" + this.getId() + "]"
                + " - " + this.getTitle()
                + " - " + this.getCategory()
                + " - " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        String[] words = title.split(" ");

        for (String word : words) {
            // Matching rules in Lab 02. Comparison is case-insensitive
            if (!this.getTitle().toLowerCase().contains(word.toLowerCase()))
                return false;
        }

        return true;
    }
}
