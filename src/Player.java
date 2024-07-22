import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
    /**
     * Stores x coordinate of the player sprite
     */
    private int x;

    /**
     * Stores x coordinate of the player sprite
     */
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

    /**
     * Stores image of the player sprite
     */
    private Image image;

    /**
     * rate of movement
     */
    private int speed=2;

    /**
     * solid area defined for collision detection
     */
    public Rectangle solidarea;

    /**
     * health stores the points of the player
     */
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

        //defines the solid area of the sprite for collision
        solidarea=new Rectangle(x+33,y+80,64,15);
    }
    
    /**
     * Sets x coordinate of player sprite on viewport
     * @param x
     */
    public void setX(int x)
    {
        this.x=x;
    }
   
    /**
     * Sets y coordinate of player sprite on viewport
     * @param y
     */
    public void setY(int y)
    {
        this.y=y;
    }

    /**
     * Returns x coordinate of the player sprite on viewport
     * @return
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns y coordinate of the player sprite on viewport
     */
    public int getY()
    {
        return y;
    }

    /**
     * Returns width of the player sprite 
     */
    public int getWidth()
    {
        return w;
    }

    /**
     * Returns height of the player sprite
     */
    public int getHeight()
    {
        return h;
    }

    /**
     * Returns image of the player sprite
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * Moves the sprite left or right horizontally
     * @param endOfScreen- defines the x coordinate of the end of the viewport
     */
    public void move(int endOfScreen)
    {
        if(x==0)
        {
            if(dx==speed)
            x+=dx;
        }
        else if((x+128)==endOfScreen)
        {
            if(dx==-speed)
            x+=dx;
        }
        else
        x+=dx;

        solidarea.setLocation(x+33,y+80);
    }

    /**
     * Defines which side the player sprite will shift corresponding to the 
     * key pressed by the player
     * @param e - This is a KeyEvent
     */
    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=-speed;

        if(key==KeyEvent.VK_RIGHT)
            dx=speed;
    }

    /**
     * Defines that the player movement is to be stopped when key is released
     * @param e - This is a KeyEvent
     */
    public void keyReleased(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=0;
        
        if(key==KeyEvent.VK_RIGHT)
            dx=0;   
    }
}
