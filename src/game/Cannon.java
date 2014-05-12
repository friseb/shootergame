package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Cannon
{
    private boolean turn        = true;
    private int     shift       = 0;
    private int     distance    = 50;
    private int     l_x1;
    private int     l_x2;
    private int     l_y1;
    private int     l_y2;
    private int     charge      = 0;
    private int     diameter    = 20;
    private int     posx;
    private int     chargeWidth = 10;
    private Game    game;

    public Cannon(Game game, int posx, boolean turn)
    {
        this.game = game;
        this.posx = posx;
        this.turn = turn;
    }

    private void calcLine()
    {
        // fest
        this.l_x1 = this.posx + this.diameter / 2;
        this.l_y1 = game.getHeight() - this.distance;

        // variabel
        this.l_x2 = this.l_x1 + this.shift;
        //pythagoras zur berechnung des punktes auf dem kreis
        double a = Math.pow(this.diameter / 2, 2);
        double b = Math.pow(this.shift, 2);
        this.l_y2 = (int) (this.l_y1 - Math.sqrt(a - b));
    }

    public void paint(Graphics2D g)
    {
        calcLine();

        g.drawOval(posx, game.getHeight() - this.diameter / 2 - this.distance,
                this.diameter, this.diameter);
        g.fillRect(posx + this.diameter / 2 - this.chargeWidth / 2,
                game.getHeight() - this.diameter / 2 - this.distance
                        - this.diameter - this.charge, this.chargeWidth,
                this.charge);
        g.drawLine(this.l_x1, this.l_y1, this.l_x2, this.l_y2);
    }

    public void keyPressed(int e)
    {
        // space
        if (e == KeyEvent.VK_SPACE && this.charge < 100)
        {
            this.charge++;
        }
        // left
        if (e == KeyEvent.VK_LEFT || e == KeyEvent.VK_D)
        {
            if (this.shift > -1 * (this.diameter / 2))
                this.shift--;
        }
        // right
        if (e == KeyEvent.VK_RIGHT || e == KeyEvent.VK_D)
        {
            if (this.shift < this.diameter / 2)
            {
                this.shift++;
            }
        }
    }

    public void stopcharge()
    {
        this.charge = 0;
    }

    public void setTurn(boolean turn)
    {
        this.turn = turn;
    }

    public boolean getTurn()
    {
        return this.turn;
    }
}
