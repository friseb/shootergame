package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel
{

    private int gameWidth  = 600;
    private int gameHeight = 400;
    private int distance   = 50;
    Surface     surface    = new Surface(this);
    Cannon      cannon1    = new Cannon(this, this.distance, true);
    Cannon      cannon2    = new Cannon(this, this.gameWidth - this.distance,
                                   false);

    public Game()
    {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                cannon1.setTurn(!cannon1.getTurn());
                cannon2.stopcharge();
                cannon1.stopcharge();

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                if (cannon1.getTurn())
                {
                    cannon1.keyPressed(e.getKeyCode());
                }
                else
                {
                    cannon2.keyPressed(e.getKeyCode());
                }

            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        surface.paint(g2d);
        cannon1.paint(g2d);
        cannon2.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Cannons");

        Game game = new Game();

        frame.add(game);
        frame.setSize(game.gameWidth, game.gameHeight);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true)
        {
            game.repaint();
            Thread.sleep(10);
        }
    }
}
