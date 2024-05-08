/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        for (String author : authors)
            if (author.equals(authorName)) {
                System.out.println("Duplicated name.");
                return;
            }
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++)
            if (authors.get(i).equals(authorName)) {
                authors.remove(i);
                System.out.println("Author has been removed.");
                return;
            }
    }

    @Override
    public String toString() {
        return "Book [" + this.getId() + "]"
                + " - " + this.getTitle()
                + " - " + this.getCategory()
                + " - " + this.getCost() + "$";
    }
}
