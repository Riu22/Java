import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pnegre

 Exemple:

 // Create Turtle object
 Turtle t = new Turtle(500,500);

 // Movements
 t.goTo(-100,-100);
 t.forward(200);
 t.turnRight(90);
 t.forward(200);
 t.turnRight(90);
 t.forward(200);
 t.turnRight(90);
 t.forward(200);

 // Show cursor
 t.markCursor();

 // Show canvas
 t.show();

 */

public class Turtle {
    private static int SIZEX;
    private static int SIZEY;
    private MyFrame frame;
    private double x = 0, y = 0;
    private double angle = 0;
    private Color color = Color.BLACK;
    private static int thickness = 1;
    private boolean penDown = true;
    private int delay = 0;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public enum Color {
        BLACK, RED, YELLOW, BLUE
    }

    private static class Line {
        int x1, y1, x2, y2;
        Color color = Color.BLACK;
        boolean visible = true;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class MyPanel extends JPanel {
        List<Line> lineList = new ArrayList<Line>();
        int step = 0;

        java.awt.Color redColor =  new java.awt.Color(255,0,0);
        java.awt.Color blackColor =  new java.awt.Color(0,0,0);
        java.awt.Color yellowColor =  new java.awt.Color(255, 253, 0);
        java.awt.Color blueColor =  new java.awt.Color(0, 93, 250);

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(thickness));
            lineList.stream()
                    .limit(step)
                    .filter(l -> l.visible)
                    .forEach(l -> drawLine(g2, l.x1, l.y1, l.x2, l.y2, l.color));
        }

        private void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color color) {
            int dx = SIZEX / 2;
            int dy = SIZEY / 2;
            g.setColor(getColor(color));
            g.drawLine(x1 + dx, y1 + dy, x2 + dx, y2 + dy);
        }

        private java.awt.Color getColor(Color color) {
            switch(color) {
                case RED: return redColor;
                case BLACK: return blackColor;
                case YELLOW: return yellowColor;
                case BLUE: return blueColor;
            }
            throw new RuntimeException("Color not valid");
        }

        public boolean doStep() {
            if (step < lineList.size()) {
                step++;
                return false;
            }
            return true;
        }

        public void allSteps() {
            step = lineList.size();
        }
    }

    private static class MyFrame extends JFrame {
        MyPanel panel;

        public MyFrame(int sx, int sy) {
            super("Turtle");
            panel = new MyPanel();
            panel.setPreferredSize(new Dimension(sx, sy));
            this.add(panel);
            this.pack();
            //this.setIgnoreRepaint(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setFocusable(true);

            this.addComponentListener(new ComponentListener() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int h = e.getComponent().getHeight();
                    int w = e.getComponent().getWidth();
                    SIZEX = w;
                    SIZEY = h;
                }

                @Override
                public void componentMoved(ComponentEvent e) {

                }

                @Override
                public void componentShown(ComponentEvent e) {

                }

                @Override
                public void componentHidden(ComponentEvent e) {

                }
            });
        }

        void addLine(Line l) {
            panel.lineList.add(l);
        }
    }

    public Turtle(int sx, int sy) {
        SIZEX = sx;
        SIZEY = sy;
        frame = new MyFrame(sx, sy);
        resetAngle();
    }

    public void show() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        if (delay > 0) {
            Timer timer = new Timer(0, null);
            timer.setDelay(delay);
            timer.addActionListener(e -> {
                boolean done = frame.panel.doStep();
                //frame.invalidate();
                //frame.validate();
                frame.repaint();
                if (done) {
                    timer.stop();
                }
            });
            timer.start();
        } else {
            frame.panel.allSteps();
            frame.invalidate();
            frame.validate();
            frame.repaint();
        }
    }

    public void markCursor() {
        markCursor(Color.BLACK);
    }

    public void markCursor(Color c) {
        double xx = x;
        double yy = y;
        double ang = angle;
        boolean pd = penDown;
        Color cc = color;

        setColor(c);
        penDown = true;
        forward(20);
        turnRight(35);
        forward(-20);
        forward(20);
        turnLeft(70);
        forward(-20);

        setColor(cc);
        penDown = pd;
        x = xx;
        y = yy;
        angle = ang;
    }

    private int transformX(double xx) {
        return (int) Math.round(xx);
    }

    private int transformY(double yy) {
        return (int) -Math.round(yy);
    }

    public void turnRight(int howMuch) {
        angle -= howMuch;
    }

    public void turnLeft(int howMuch) {
        angle += howMuch;
    }

    public void forward(int howMuch) {
        double realAngle = (angle + 90) * Math.PI / 180d;
        double newx = (x + ((double) howMuch) * Math.cos(realAngle));
        double newy = (y + ((double) howMuch) * Math.sin(realAngle));

        int x1 = transformX(x), y1 = transformY(y);
        int x2 = transformX(newx), y2 = transformY(newy);
        Line line = new Line(x1, y1, x2, y2);
        if (!penDown) line.visible = false;
        line.color = color;
        frame.addLine(line);

        x = newx;
        y = newy;
    }

    public void resetAngle() {
        angle = 0d;
    }

    public void goTo(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }
}