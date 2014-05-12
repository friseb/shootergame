package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Cannon
{
    private boolean turn        = true;
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
        this.l_x1 = this.posx + this.diameter / 2;
        this.l_y1 = game.getHeight() - 50 ;
        this.l_x2 = this.posx + this.diameter/2;
        this.l_y2 = game.getHeight() - this.diameter / 2 - 50;
    }

    public void paint(Graphics2D g)
    {
        g.drawOval(posx, game.getHeight() - this.diameter / 2 - 50,
                this.diameter, this.diameter);
        g.fillRect(posx + this.diameter / 2 - this.chargeWidth / 2,
                game.getHeight() - this.diameter / 2 - 70 - this.charge,
                this.chargeWidth, this.charge);
        g.drawLine(this.l_x1, this.l_y1, this.l_x2, this.l_y2);
        System.out.println(this.l_x1 +" "+ this.l_y1 +" "+ this.l_x2 +" "+ this.l_y2);
    }

    public void keyPressed(int e)
    {
        // space
        if (e == 32 && this.charge < 100)
        {
            this.charge++;
        }
        // left
        if (e == KeyEvent.VK_LEFT || e == KeyEvent.VK_D)
        {

        }
        // right
        if (e == KeyEvent.VK_RIGHT || e == KeyEvent.VK_D)
        {

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
