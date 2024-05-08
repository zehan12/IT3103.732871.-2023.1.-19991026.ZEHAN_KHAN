/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.AddBookToStoreScreen;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CartScreenController {
    private final Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    public void btnRemovePressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    public void btnPlayPressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        JDialog playDialog = new JDialog();
        playDialog.setTitle("Play Media");
        playDialog.setSize(400, 300);
        playDialog.setLayout(new BorderLayout());

        JLabel mediaLabel = new JLabel("Media playback goes here");
        try {
            Playable playableMedia = (Playable) media;
            playableMedia.play();
        } catch (Exception error) {
            error.printStackTrace();
        }

        mediaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playDialog.add(mediaLabel, BorderLayout.CENTER);

        playDialog.setModal(true);
        playDialog.setAlwaysOnTop(true);
        playDialog.setVisible(true);
    }

    @FXML
    public void btnPlaceOrderPressed(ActionEvent actionEvent) {
        if (cart.getItemsOrdered().isEmpty()) return;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText("Order Placed");
        alert.setContentText("Thank you for ordering");

        alert.showAndWait();

        cart.getItemsOrdered().clear();
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldMedia, Media newMedia) {
                if (newMedia != null) updateButtonBar(newMedia);
            }
        });

        lblTotalCost.setText(String.format("%.2f$", cart.getTotalCost()));
        cart.totalCostProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            Platform.runLater(() -> {
                lblTotalCost.setText(String.format("%.2f$", newValue.doubleValue()));
            });
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    void showFilteredMedia(String input) {
        if (Objects.equals(input, "")) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }

        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());
        if (radioBtnFilterId.isSelected())
            filteredList.setPredicate((media) -> media.getId() == Integer.parseInt(input));
        else
            filteredList.setPredicate((media) -> media.isMatch(input));

        tblMedia.setItems(filteredList);
    }
}
