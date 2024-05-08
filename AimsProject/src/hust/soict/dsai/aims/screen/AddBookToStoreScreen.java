/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.screen.controller.AddBookToStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class AddBookToStoreScreen extends JFrame {
    public AddBookToStoreScreen() throws HeadlessException {
        super();

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book to Store");
        this.setVisible(true);
        this.setSize(420, 280);
        this.setAlwaysOnTop(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(
                            Objects.requireNonNull(getClass().getResource("fxml/AddBookToStore.fxml")));

                    AddBookToStoreController controller = new AddBookToStoreController();
                    loader.setController(controller);

                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
