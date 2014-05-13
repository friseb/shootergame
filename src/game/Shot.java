package game;

import java.awt.Graphics2D;

public class Shot
{
    private int currentx = 2000;
    private int currenty = 2000;
    private int shift;
    private int charge;
    private int diameter = 4;

    public void shoot(int startx, int starty, int shift, int charge)
    {
        this.charge = charge * 4; // 1-100
        this.shift = shift; // -10 ... 10

        this.currentx = startx - this.diameter / 2;
        this.currenty = starty - this.diameter / 2;

        this.fly();
    }

    public void fly()
    {
        this.currentx += (int) this.shift;
        this.currenty += this.charge / -10;
        this.charge -= 2;
    }

    public void paint(Graphics2D g)
    {
        g.fillOval(this.currentx, this.currenty, this.diameter, this.diameter);
    }
}
