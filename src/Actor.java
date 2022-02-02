import java.awt.*;

public abstract class Actor {
    protected int score;
    protected int speed;

    protected Sprite s;
    protected RectCollider r;
    protected boolean active = true;

    Actor (double x, double y, String fileName, Point p) {
        s = new Sprite(x, y, fileName, p);
    }

    public double getX(){
        return s.x;
    }

    public double getY(){
        return s.y;
    }

    public void paint (Graphics g) {
        if(!active) {
            return;
        }
        s.paint(g);
        //r.paint(g);
    }

    public void onIntersects(Platform plat) {
        if (plat.x == s.x) {
            active = false;
        }
    }

    public void update (int ms) {
        if(!active) {
            return;
        }
        if (getY() >= Size.h + 100){
            Game.score -= 10;
            respawn();
        }
        s.update(ms);

    }

    protected void respawn() {
        s.x = Math.random() * 700;
        s.y = -100;
    }
}

class Woman extends Actor {

    public Woman(double x, double y) {
        super(x, y, "woman.png", new Point(0, 0));
        r = new RectCollider(x + 20, y + 60, 50, 20);

        s.frameWidth = 115; // всего 12
        s.frameHeight = 87;

        for (int i = 0; i < 12; i++){
            s.addFrame(new Point(i * s.frameWidth, 0));
        }

        respawn();
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider(getX() + 20, getY() + 60, 50, 20);
    }
}

class Guy extends Actor {

    public Guy(double x, double y) {
        super(x, y, "guy.png", new Point(0, 0));
        r = new RectCollider(x + 40, y + 80, 50, 20);

        s.frameWidth = 117; // всего 12
        s.frameHeight = 141;

        for (int i = 0; i < 12; i++){
            s.addFrame(new Point(i * s.frameWidth, 0));
        }

        respawn();
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider(getX() + 40, getY() + 80, 50, 20);
    }
}

class Girl extends Actor {

    public Girl(double x, double y) {
        super(x, y, "girl.png", new Point(0, 0));
        r = new RectCollider(x + 40, y + 80, 50, 20);
        s.frameWidth = 140; // всего 12
        s.frameHeight = 130;

        for (int i = 0; i < 12; i++){
            s.addFrame(new Point(i * s.frameWidth, 0));
        }

        respawn();
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider(getX() + 40, getY() + 80, 50, 20);
    }
}

class Plane extends Actor {

    public Plane(double x, double y) {
        super(x, y, "plane.png", new Point(0, 0));
        r = new RectCollider(x + 20, y + 20, 50, 50);
        s.frameWidth = 101; // всего 12
        s.frameHeight = 93;

        for (int i = 0; i < 12; i++){
            s.addFrame(new Point(i * s.frameWidth, 0));
        }

        respawn();
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider(getX() + 20, getY() + 20, 50, 50);
    }
}

class Chemodan extends Actor {

    public Chemodan(double x, double y) {
        super(x, y, "chemodan.png", new Point(0, 0));
        r = new RectCollider(x + 20, y + 70, 60, 30);
        s.frameWidth = 83; // всего 12
        s.frameHeight = 113;

        for (int i = 0; i < 12; i++){
            s.addFrame(new Point(i * s.frameWidth, 0));
        }

        respawn();
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider(getX() + 20, getY() + 70, 60, 30);
    }
}
