
import java.awt.Image;

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
    
    public Egg(int h)
    {
        initEgg();
        visible=true;
        this.h=h;
        addNotify();
        System.out.println("here");
    }

    private void initEgg()
    {
        loadImage();

        x=(int)Math.random()* 1280;
        System.out.println(x);
        y=INITIAL_Y;
    }

    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Egg-Basket-Java-Game\\src\\Assets\\Sprites\\eggSprite.png");
        egg=ii.getImage();

        
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
        //x+=1;
        y+=2;
        if(y==h-egg.getHeight(null)+50)
        {
           
            ImageIcon ii=new ImageIcon("E:\\CODES\\Egg-Basket-Java-Game\\src\\Assets\\Sprites\\OmleteSprite.png");
            egg=ii.getImage();
        }
        if(y==h)
        {
            visible=false;
        }
    }

    public boolean isVisible()
    {
        return(visible);
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

                // JOptionPane.showMessageDialog(this, msg, "Error",JOptionPane.ERROR_MESSAGE);
            }
            beforeTime=System.currentTimeMillis();
        }
    }
}

