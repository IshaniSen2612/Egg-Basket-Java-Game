import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
    private int x;
    private int y;
    /**
     * shift horizontally
     */
    private int dx;
    /**
     * width of the player sprite image
     */
    private int w; 
    /**
     * height of the player sprite image
     */
    private int h;
    private Image image;
    /**
     * rate of movement
     */
    private int speed=2;
    public Rectangle solidarea;
    public int health=3;
    
    public Player()
    {
        loadImage();
    }

    /**
     * loadImage() loads the image to be used as sprite
     */
    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Egg-Basket-Java-Game\\src\\Assets\\Sprites\\player-sprite.png");
        
        image=ii.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT);
       
        w=image.getWidth(null);
        h=image.getHeight(null);

        solidarea=new Rectangle(x+33,y+80,64,15);
    }
    
    public void setX(int x)
    {
        this.x=x;
    }
   
    public void setY(int y)
    {
        this.y=y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return w;
    }

    public int getHeight()
    {
        return h;
    }

    public Image getImage()
    {
        return image;
    }

    public void move(int end)
    {
        if(x==0)
        {
            if(dx==speed)
            x+=dx;
        }
        else if((x+128)==end)
        {
            if(dx==-speed)
            x+=dx;
        }
        else
        x+=dx;

        solidarea.setLocation(x+33,y+80);
    }

    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=-speed;

        if(key==KeyEvent.VK_RIGHT)
            dx=speed;
    }

    public void keyReleased(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=0;
        
        if(key==KeyEvent.VK_RIGHT)
            dx=0;   
    }
}
