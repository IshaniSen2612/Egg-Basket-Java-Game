import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
    private int x;
    private int y;
    private int dx;
    private int w;
    private int h;
    private Image image;
    
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

    public void move()
    {
        x+=dx;
    }

    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=-2;

        if(key==KeyEvent.VK_RIGHT)
            dx=2;
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
