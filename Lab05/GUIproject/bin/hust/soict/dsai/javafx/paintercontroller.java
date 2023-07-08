package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;

public class PainterController {
    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penRadioButton;
    @FXML private RadioButton eraserRadioButton;
    @FXML private TitledPane ToolsPane;
    @FXML private ToggleGroup tools;
    private Paint color = Color.BLACK;

    @FXML
    public void initialize() {
        penRadioButton.setToggleGroup(tools);
        eraserRadioButton.setToggleGroup(tools);
    }
    
    @FXML
    void chooseToolPressed(ActionEvent e) {
        color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
