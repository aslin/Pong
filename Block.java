import java.awt.Graphics2D;
import java.awt.Color;
public class Block extends GameObject
{
    private int vel = 3;
    public Block(int x, int y, Color color)
    {
        super(x,y,10,40,color);
    }
    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillRect(x,y,w,h);
    }
    public void moveUp()
    {
        y -= vel;
    }
    public void moveDown()
    {
        y += vel;
    }
    
}
