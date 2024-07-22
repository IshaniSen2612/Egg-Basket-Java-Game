import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Viewport extends JPanel implements ActionListener 
{
    private Timer timer;
    private Timer timer2;
    private Player player;
    private final int DELAY=10; 

    /**
     * Stores x-coordinate of player sprite
     */
    private int x;

    /**
     * Stores y coordinate of player sprite
     */
    private int y;

    /**
     * width of Viewport
     */
    private int w;

    /**
     * height of Viewport
     */
    private int h;

    /**
     * stores the points collected
     */
    private int points=0;

    /**
     * ArrayList of egg sprites spawned
     */
    private List<Egg> eggs=new ArrayList<>();

    public Viewport(int w, int h)
    {
        initBoard();
        this.w=w;
        this.h=h;
        x = w / 2 - 56;
        y = h - 172;
        player.setX(x);
        player.setY(y);
    }

    private void initBoard()
    {
        addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        player = new Player();

        timer = new Timer(DELAY,this);
        timer.start();

        timer2 = new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eggs.size()<6)
                {
                    eggs.add(new Egg(h,player));
                }
                else
                {
                  eggs.remove(0);
                }
            }
        });
        timer2.start();
    }   

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        draw(g);
        spawnEggs(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(player.getImage(),player.getX(),player.getY(),this);
    }
    
    private void spawnEggs(Graphics g)
    {   
        Graphics2D g2d=(Graphics2D) g;
        for(Egg e:eggs)
        {
            if(e.isVisible())
                g2d.drawImage(e.getImage(),e.getX(),e.getY(),this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        step();
    }

    private void step()
    {
        player.move(w);
        if(player.health<=0)
        {
            System.out.println("Game over");
            drawGameOver(getGraphics());
            timer.stop();
            timer2.stop();
        }
        checkCollisions();
        repaint();     
    }

    public void checkCollisions() 
    {

        Rectangle  r1 = player.solidarea.getBounds();

        for(Egg e: eggs) {
            if(e.getY()>500 && e.isVisible())
            {
                Rectangle r2 = e.solidarea.getBounds();

                if (r2.intersects(r1)) 
                {
                    System.out.println("Collided");
                    points++;
                    System.out.println(points);
                    e.setVisible(false);
                }
            }
        }
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (w- fm.stringWidth(msg)) / 2,
                h / 2);
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) 
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            player.keyPressed(e);
        }
    }
}
