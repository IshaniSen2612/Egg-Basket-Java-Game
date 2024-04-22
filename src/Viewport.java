import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Viewport extends JPanel implements ActionListener 
{
    private Timer timer;
    private Timer timer2;
    private Player player;
    private Egg egg;
    private final int DELAY=10; 
    private int x;
    private int y;
    private int w;
    private int h;
    private boolean eggSpawned;

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
        setBackground(Color.black);
        setFocusable(true);

        player = new Player();

        timer = new Timer(DELAY,this);
        timer.start();

        timer2 = new Timer(2000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
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
        // For finding out the origin point of the player sprite
        // g.setColor(Color.WHITE);
        // g.drawOval(player.getX(), player.getY(), 1, 1);
    }

    private void spawnEggs(Graphics g)
    {   
        if(!eggSpawned)
        {
            egg=new Egg(h);
            eggSpawned=true;
        }

        Graphics2D g2d=(Graphics2D) g;

        if(egg.isVisible())
        g2d.drawImage(egg.getImage(),egg.getX(),egg.getY(),this);
        else
        {
            eggSpawned=false;
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
        repaint();
        // repaint(player.getX()-1,player.getY()-1,player.getWidth()+2,player.getHeight()+2);
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
