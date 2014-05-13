package game;

import java.awt.Graphics2D;

public class Surface
{
    private Game game;

    public static final int  height = 50;

    public Surface(Game game)
    {
        this.game = game;
    }

    public void paint(Graphics2D g)
    {
        g.fillRect(0, game.getHeight() - Surface.height, game.getWidth(),
                Surface.height);
    }
}
