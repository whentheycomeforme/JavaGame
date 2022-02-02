import java.awt.*;

public class Platform extends Sprite {
    //double x, y;
    public RectCollider r = new RectCollider((int)x + 40, (int)y, 60, 20);

    public Platform(double x, double y){
        super(x, y, "platform.png");
        setAlpha(Math.PI);
        setSpeed(250);
    }

    public void right(){
        setAlpha(0);
    }
    public void left(){
        setAlpha(Math.PI);
    }

    @Override
    public void update(int ms){
        super.update(ms);
        r = new RectCollider((int)x + 40, (int)y, 60, 20);
        setSpeed(Game.speed + 100);

        if (super.x <= 0){
            super.x = 0;
            setAlpha(0);
        }

        if (super.x >= Size.w - 140){
            super.x = Size.w - 140;
            setAlpha(Math.PI);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        //r.paint(g);
    }
}
