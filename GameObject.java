import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public abstract class GameObject implements Drawable
{
  
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Color color;
    
    public GameObject(int x, int y, int w, int h, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h; 
        this.color = color;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }
    public Rectangle getBoundary()
    {
        return new Rectangle(x,y,w,h);
    }
    
    
}
