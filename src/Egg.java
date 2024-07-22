
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Egg implements Runnable
{
    private final int INITIAL_Y=0;
    private final int DELAY=25;

    private Image egg;
    private Thread animator;
    private int x,y;
    private boolean visible;
    private int h;
    public Rectangle solidarea;
    public Player p;
    
    
    public Egg(int h, Player player)
    {
        initEgg();
        visible=true;
        this.h=h;
        addNotify();
        this.p=player;
    }

    private void initEgg()
    {
        loadImage();
        x=(int)((Math.random()* 1280)-egg.getWidth(null));
        if(x<0){
            x=0;
        }
        y=INITIAL_Y;
    }

    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Egg-Basket-Java-Game\\src\\Assets\\Sprites\\eggSprite.png");
        egg=ii.getImage();

        solidarea=new Rectangle(x,y,egg.getWidth(null),egg.getHeight(null));
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Image getImage()
    {
        return egg;
    }

    private void move()
    {
        y+=1;
        if(y==h-egg.getHeight(null)) //height of viewport-height of egg sprite
        {
           
            ImageIcon ii=new ImageIcon("E:\\CODES\\Egg-Basket-Java-Game\\src\\Assets\\Sprites\\OmleteSprite.png");
            egg=ii.getImage();

            p.health--;
            System.out.println("Health decreased: "+p.health);
        }
        if(y==h)
        {
            visible=false;
        }
        solidarea.setLocation(x,y);
    }

    public boolean isVisible()
    {
        return(visible);
    }
    
    public void setVisible(boolean b)
    {
        visible=b;
    }
    
    public void addNotify() {
        animator=new Thread(this);
        animator.start();
    }

    public void run()
    {
        long beforeTime, timeDiff, sleep;

        beforeTime=System.currentTimeMillis();

        while(true)
        {
            if(!this.isVisible())
            {
                break;
            }
            move();
            timeDiff=System.currentTimeMillis()-beforeTime;
            sleep=DELAY-timeDiff;

            if(sleep<0)
            sleep=2;

            try
            {
                Thread.sleep(sleep);   
            }catch(InterruptedException e){
                String msg=String.format("Thread interrupted: %s",e.getMessage());
                System.out.println(msg);
            }
            beforeTime=System.currentTimeMillis();
        }
    }
}

