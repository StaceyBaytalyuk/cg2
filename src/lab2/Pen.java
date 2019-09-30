package lab2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pen {
    private GraphicsContext gc;
    private Canvas canvas;
    private double minX = -50;
    private double maxX = 50;
    private double minY = -50;
    private double maxY = 50;
    private Color color = Color.RED;

    public Pen(GraphicsContext gc, Canvas canvas) {
        this.gc = gc;
        this.canvas = canvas;
    }

    public void setColor(Color color) { this.color = color; gc.setStroke(color); }

    public void drawPixel(double x, double y) { gc.strokeLine(x, y, x, y); }

    public void drawLine(Point p1, Point p2){ drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()); }

    public void drawLine(double x1, double y1, double x2, double y2){
        x1 = toScreenX(x1); y1 = toScreenY(y1);
        x2 = toScreenX(x2); y2 = toScreenY(y2);

        double dx = x2 - x1; double dy = y2 - y1;
        int incX, incY;

        if ( dx > 0 ) incX = 1;
        else if ( dx < 0 ) incX = -1;
        else incX = 0;

        if ( dy > 0 ) incY = 1;
        else if ( dy < 0 ) incY = -1;
        else incY = 0;

        dx = Math.abs(dx); dy = Math.abs(dy);
        double d;
        if ( dx > dy ) d = dx;
        else d = dy;

        int xErr = 0; int yErr = 0;
        double x = x1; double y = y1;
        drawPixel(x,y);

        for (int i = 0; i < d; i++) {
            xErr += dx;
            yErr += dy;
            if ( xErr > d ) {
                xErr -= d;
                x += incX;
            }

            if ( yErr > d ) {
                yErr -= d;
                y += incY;
            }
            drawPixel(x,y);
        }
    }

    public void drawAxis() {
        gc.setStroke(Color.BLACK);
        gc.strokeLine(toScreenX(minX), toScreenY(0), toScreenX(maxX), toScreenY(0));
        gc.strokeLine(toScreenX(0),toScreenY(maxY),toScreenX(0),toScreenY(minY));
        gc.setStroke(color);
    }

    private int toScreenX(double x) { return (int) (canvas.getWidth() * (x - minX) / (maxX - minX)); }
    private int toScreenY(double y) { return (int) (canvas.getHeight() * (1 - (y - minY) / (maxY - minY))); }
}