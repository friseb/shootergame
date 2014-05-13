package game;

import java.awt.Graphics2D;

public class Shot
{
    private Game game;
    private int currentx = 2000;
    private int currenty = 2000;
    private int shift;
    private int charge;
    private int diameter = 4;

    public Shot(Game game)
    {
        this.game = game;
    }

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
        if (this.currenty + this.charge / -10 < this.game.getHeight()
                - Surface.height)
        {
            this.currenty += this.charge / -10;
        }
        else
        {
            this.currenty = 2000;
        }
        this.charge -= 2;
    }

    public void paint(Graphics2D g)
    {
        g.fillOval(this.currentx, this.currenty, this.diameter, this.diameter);
    }
}
