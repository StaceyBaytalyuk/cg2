package lab2;

public class Figure {
    private Point center = new Point(0, 0);
    private Point[] letter = { new Point(-8, -8), new Point(-8, 8), new Point(0, 8), new Point(0, 6), new Point(-6, 6), new Point(-6, 0), new Point(-2, 0), new Point(0, -2), new Point(0, -6), new Point(-2, -8) };
    private Point[] hole = { new Point(-6, -6), new Point(-6, -2), new Point(-3, -2), new Point(-2, -3), new Point(-2, -5), new Point(-3, -6) };
    private Point[] number = { new Point(4, -8), new Point(4, -6), new Point(6, -6), new Point(6, 4), new Point(4, 2), new Point(3, 3), new Point(6, 8), new Point(8, 8), new Point(8, -8) };
    private int angle = 0;
    private double scale = 1;
    private Pen pen;

    public Figure(Pen pen) { this.pen = pen; }

    public void draw() {
        calculatePoints();
        pen.drawLine(letter[0], letter[1]);
        pen.drawLine(letter[1], letter[2]);
        pen.drawLine(letter[2], letter[3]);
        pen.drawLine(letter[3], letter[4]);
        pen.drawLine(letter[4], letter[5]);
        pen.drawLine(letter[5], letter[6]);
        pen.drawLine(letter[6], letter[7]);
        pen.drawLine(letter[7], letter[8]);
        pen.drawLine(letter[8], letter[9]);
        pen.drawLine(letter[9], letter[0]);

        pen.drawLine(hole[0], hole[1]);
        pen.drawLine(hole[1], hole[2]);
        pen.drawLine(hole[2], hole[3]);
        pen.drawLine(hole[3], hole[4]);
        pen.drawLine(hole[4], hole[5]);
        pen.drawLine(hole[5], hole[0]);

        pen.drawLine(number[0], number[1]);
        pen.drawLine(number[1], number[2]);
        pen.drawLine(number[2], number[3]);
        pen.drawLine(number[3], number[4]);
        pen.drawLine(number[4], number[5]);
        pen.drawLine(number[5], number[6]);
        pen.drawLine(number[6], number[7]);
        pen.drawLine(number[7], number[8]);
        pen.drawLine(number[8], number[0]);
    }

    public void move(int dx, int dy) {
        double x = center.getX();
        center.setX(x+dx);
        double y = center.getY();
        center.setY(y+dy);
    }
    public void zoom(double n) { scale *= n; }
    public void rotate(int deg) { angle += deg; }


    private void calculatePoints() {
        double deg = angle*(Math.PI/180);
        double sin = Math.sin(deg);
        double cos = Math.cos(deg);
        double x0 = center.getX();
        double y0 = center.getY();
        double x, y;

//outer contour of letter
        x = -8 * scale * cos - -8 * scale * sin;
        y = -8 * scale * sin + -8 * scale * cos;
        letter[0].setX(x + x0);
        letter[0].setY(y + y0);

        x = -8 * scale * cos - 8 * scale * sin;
        y = -8 * scale * sin + 8 * scale * cos;
        letter[1].setX(x + x0);
        letter[1].setY(y + y0);

        x = 0 * scale * cos - 8 * scale * sin;
        y = 0 * scale * sin + 8 * scale * cos;
        letter[2].setX(x + x0);
        letter[2].setY(y + y0);

        x = 0 * scale * cos - 6 * scale * sin;
        y = 0 * scale * sin + 6 * scale * cos;
        letter[3].setX(x + x0);
        letter[3].setY(y + y0);

        x = -6 * scale * cos - 6 * scale * sin;
        y = -6 * scale * sin + 6 * scale * cos;
        letter[4].setX(x + x0);
        letter[4].setY(y + y0);

        x = -6 * scale * cos - 0 * scale * sin;
        y = -6 * scale * sin + 0 * scale * cos;
        letter[5].setX(x + x0);
        letter[5].setY(y + y0);

        x = -2 * scale * cos - 0 * scale * sin;
        y = -2 * scale * sin + 0 * scale * cos;
        letter[6].setX(x + x0);
        letter[6].setY(y + y0);

        x = 0 * scale * cos - -2 * scale * sin;
        y = 0 * scale * sin + -2 * scale * cos;
        letter[7].setX(x + x0);
        letter[7].setY(y + y0);

        x = 0 * scale * cos - -6 * scale * sin;
        y = 0 * scale * sin + -6 * scale * cos;
        letter[8].setX(x + x0);
        letter[8].setY(y + y0);

        x = -2 * scale * cos - -8 * scale * sin;
        y = -1 * scale * sin + -8 * scale * cos;
        letter[9].setX(x + x0);
        letter[9].setY(y + y0);


//inner contour of letter
        x = -6 * scale * cos - -6 * scale * sin;
        y = -6 * scale * sin + -6 * scale * cos;
        hole[0].setX(x + x0);
        hole[0].setY(y + y0);

        x = -6 * scale * cos - -2 * scale * sin;
        y = -6 * scale * sin + -2 * scale * cos;
        hole[1].setX(x + x0);
        hole[1].setY(y + y0);

        x = -3 * scale * cos - -2 * scale * sin;
        y = -3 * scale * sin + -2 * scale * cos;
        hole[2].setX(x + x0);
        hole[2].setY(y + y0);

        x = -2 * scale * cos - -3 * scale * sin;
        y = -2 * scale * sin + -3 * scale * cos;
        hole[3].setX(x + x0);
        hole[3].setY(y + y0);

        x = -2 * scale * cos - -5 * scale * sin;
        y = -2 * scale * sin + -5 * scale * cos;
        hole[4].setX(x + x0);
        hole[4].setY(y + y0);

        x = -3 * scale * cos - -6 * scale * sin;
        y = -3 * scale * sin + -6 * scale * cos;
        hole[5].setX(x + x0);
        hole[5].setY(y + y0);

//number
        x = 4 * scale * cos - -8 * scale * sin;
        y = 4 * scale * sin + -8 * scale * cos;
        number[0].setX(x + x0);
        number[0].setY(y + y0);

        x = 4 * scale * cos - -6 * scale * sin;
        y = 4 * scale * sin + -6 * scale * cos;
        number[1].setX(x + x0);
        number[1].setY(y + y0);

        x = 6 * scale * cos - -6 * scale * sin;
        y = 6 * scale * sin + -6 * scale * cos;
        number[2].setX(x + x0);
        number[2].setY(y + y0);

        x = 6 * scale * cos - 4 * scale * sin;
        y = 6 * scale * sin + 4 * scale * cos;
        number[3].setX(x + x0);
        number[3].setY(y + y0);

        x = 4 * scale * cos - 2 * scale * sin;
        y = 4 * scale * sin + 2 * scale * cos;
        number[4].setX(x + x0);
        number[4].setY(y + y0);

        x = 3 * scale * cos - 3 * scale * sin;
        y = 3 * scale * sin + 3 * scale * cos;
        number[5].setX(x + x0);
        number[5].setY(y + y0);

        x = 6 * scale * cos - 8 * scale * sin;
        y = 6 * scale * sin + 8 * scale * cos;
        number[6].setX(x + x0);
        number[6].setY(y + y0);

        x = 8 * scale * cos - 8 * scale * sin;
        y = 8 * scale * sin + 8 * scale * cos;
        number[7].setX(x + x0);
        number[7].setY(y + y0);

        x = 8 * scale * cos - -8 * scale * sin;
        y = 8 * scale * sin + -8 * scale * cos;
        number[8].setX(x + x0);
        number[8].setY(y + y0);

    }

}