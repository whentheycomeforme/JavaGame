import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Window w = new Window();
        //System.out.println(w.getSize());

    }
}

class Size {
    public static int w = 774;
    public static int h = 768;
}

class Game {
    public static int score = 0;
    public static int speed = 150;
}

class Window extends JFrame {

    public Window()  {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setMaximumSize(new Dimension(774, 768));
        setMinimumSize(new Dimension(774, 768));

        setTitle("Falling People");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //System.out.println(getMaximizedBounds());


        //System.out.println(getSize());

        Panel p = new Panel();
        add(p);
        p.addMouseListener((MouseListener) p);

        addKeyListener((KeyListener) p);

        revalidate();
    }
}

class Panel extends JPanel implements KeyListener, MouseListener {

    long t1, t2;

    public Panel () {
        setFocusable(true);
        setBackground(Color.BLACK);
        t1 = System.currentTimeMillis();

    }


    Actor act = new Woman(300, 0);
    Actor guy = new Guy(500, -100);
    Actor girl = new Girl(200, -50);
    Actor plane = new Plane(100, 0);
    Actor chemodan = new Chemodan(400, -20);

    Platform platform = new Platform(10,650);
    Texture bg = new Texture(0, 0, "background.png");

    Actor[] list = new Actor[] {act, guy, null, null, null};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        t2 = System.currentTimeMillis();
        int ms = (int)(t2-t1);

        bg.paint(g);

        Game.speed = 150 + (Game.score / 60) * 20;
        g.setColor(Color.BLUE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        g.drawString("Score: " + Game.score, 10, 20);
        g.drawString("Speed: " + Game.speed, 10, 40);

        // отрисовка
        for (int i = 0; i < 5; i++){
            Actor el = list[i];
            if (el != null){
                el.paint(g);
                el.update(ms);
            }
        }

        for (int i = 0; i < 5; i++) {
            Actor el = list[i];
            if (el != null) {
                if (el.getY() > Size.h - 250) {
                    if (platform.r.ifIntersects(el.r)) {
                        Game.score += 20;

                        el.respawn();
                    }
                }
            }
        }

        if (Game.score >= 100) {
            list[2] = girl;
        }
        if (Game.score >= 200) {
            list[3] = plane;
        }
        if (Game.score >= 400) {
            list[4] = chemodan;
        }


        platform.paint(g);
        platform.update(ms);

        t1 = t2;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            platform.right();
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            platform.left();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

