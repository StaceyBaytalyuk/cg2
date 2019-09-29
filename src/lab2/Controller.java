package lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class Controller implements Initializable {
    @FXML private Menu fileMenu;
    @FXML private MenuItem closeMenu;
    @FXML private Menu settingsMenu;
    @FXML private Menu languageMenu;
    @FXML private Menu colorMenu;
    @FXML private MenuItem blackMenu;
    @FXML private MenuItem redMenu;
    @FXML private MenuItem greenMenu;
    @FXML private MenuItem blueMenu;
    @FXML private Text moveText;
    @FXML private Text scaleText;
    @FXML private Text rotateText;
    @FXML private Pane centerPane;
    @FXML private Canvas canvas;
    private GraphicsContext gc;
    private Pen pen;
    private Figure figure;

    public void close() { Platform.exit(); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas.widthProperty().bind(centerPane.widthProperty());
        canvas.heightProperty().bind(centerPane.heightProperty());
        canvas.widthProperty().addListener(e->draw());
        canvas.heightProperty().addListener(e->draw());
        gc = canvas.getGraphicsContext2D();
        pen = new Pen(gc, canvas);
        figure = new Figure(pen);
    }

    private void draw() {
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        pen.drawAxis();
        figure.draw();
    }

    public void moveUp() { figure.move(0, 5); draw(); }
    public void moveDown() { figure.move(0, -5); draw(); }
    public void moveLeft() { figure.move(-5, 0); draw(); }
    public void moveRight() { figure.move(5, 0); draw(); }
    public void zoomIn() { figure.zoom(2); draw(); }
    public void zoomOut() { figure.zoom(0.5); draw(); }
    public void rotateLeft() { figure.rotate(15); draw(); }
    public void rotateRight() { figure.rotate(-15); draw(); }

    public void onBlack() { pen.setColor(Color.BLACK); draw(); }
    public void onRed() { pen.setColor(Color.RED); draw(); }
    public void onGreen() { pen.setColor(Color.GREEN); draw(); }
    public void onBlue() { pen.setColor(Color.BLUE); draw(); }

    public void onEnglish() {
        fileMenu.setText("File");
        closeMenu.setText("Close");
        settingsMenu.setText("Settings");
        languageMenu.setText("Language");
        colorMenu.setText("Color");
        blackMenu.setText("Black");
        redMenu.setText("Red");
        greenMenu.setText("Green");
        blueMenu.setText("Blue");
        moveText.setText("  move");
        scaleText.setText("         scale ");
        rotateText.setText("        rotate ");
    }

    public void onRussian() {
        fileMenu.setText("Файл");
        closeMenu.setText("Закрыть");
        settingsMenu.setText("Настройки");
        languageMenu.setText("Язык");
        colorMenu.setText("Цвет");
        blackMenu.setText("Чёрный");
        redMenu.setText("Красный");
        greenMenu.setText("Зелёный");
        blueMenu.setText("Синий");
        moveText.setText("двигать");
        scaleText.setText("       масштаб ");
        rotateText.setText("       поворот ");
    }
}