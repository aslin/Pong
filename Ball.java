
import java.awt.Graphics2D;
import java.awt.Color;

public class Ball extends GameObject
{
    private int dx;
    private int dy;
    
    public Ball(int x, int y, Color color)
    {
        super(x,y,10,10,color);
        dx = 7;
        dy = 4;
    }
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval(x,y,w,h);
    }
    public void move()
    {
        x += dx;
        y += dy;
    }
    public void rewind()
    {
        x -= dx;
        y -= dy;
    }
    public void reverseX()
    {
        dx = -dx;
    }
    
    public void reverseY()
    {
        dy = -dy;
    }
    public int getDx()
    {
        return dx;
    }
    public int getDy()
    {
        return dy;
    }
}
