/**
 * @project GUIProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    private Color penColor = Color.BLACK;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, penColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    private void penRadioButtonSelected() {
        penColor = Color.BLACK;
        eraserRadioButton.setSelected(false);
    }

    @FXML
    private void eraserRadioButtonSelected() {
        penColor = Color.WHITE;
        penRadioButton.setSelected(false);
    }
}
