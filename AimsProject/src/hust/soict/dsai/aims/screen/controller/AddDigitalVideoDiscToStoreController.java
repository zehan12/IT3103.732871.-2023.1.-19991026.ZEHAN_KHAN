/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddDigitalVideoDiscToStoreController {
    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    @FXML
    private void addToStorePressed() {
        // Retrieve text from the TextFields
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);

        try {
            Aims.getStore().addMedia(dvd);
            Aims.closeStoreScreen();
            Aims.openStoreScreen();
        } catch (Exception e) {
        }

        // Clear the TextFields
        tfTitle.setText(null);
        tfCategory.setText(null);
        tfCost.setText(null);
        tfLength.setText(null);
        tfDirector.setText(null);
    }
}
