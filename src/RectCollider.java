import java.awt.*;

public class RectCollider {
    public double x, y;
    public int width, height;

    public RectCollider(double x, double y, int width, int height) {
        this.x = x;         this.y = y;
        this.width = width; this.height = height;
    }

    public boolean ifIntersects(RectCollider r){
        if (r.x >= x && r.x <= (x+width) && r.y >= y && r.y <= (y + height)) {
            System.out.println("1");
            System.out.println(r.x + " >= " + x);
            System.out.println(r.x + " <= " + (x + width));
            System.out.println(r.y + " >= " + y);
            System.out.println(r.y + " <= " + (y+height));
            return true;
        }
        else if ((r.x + r.width) >= x && (r.x + r.width) <= (x+width) && (r.y + r.height) >= y && (r.y + r.height) <= (y + height)) {
            System.out.println("2");
            return true;
        }
        return false;
    }

    // чтобы увидеть hitbox-ы, нужно раскомментить это + r.paint в Platform и Actor
    /*public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.drawRect((int)x, (int)y, width, height);
    }*/
}
