
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Vector;

public class GamePad implements Drawable
{
    private UserInterface ui;
    private int xSize;
    private int ySize;
    private Block player1;
    private Block player2;
    private Ball ball;  
    private Input input;
    private Computer cpu;
    
    public GamePad(UserInterface ui)
    {
        this.ui = ui;
        this.xSize = ui.getXSize();
        this.ySize = ui.getYSize();
        player1 = new Block(20,20,GSettings.getColor("white"));
        player2 = new Block(470,100,GSettings.getColor("white"));
        ball = new Ball(100,300,GSettings.getColor("white"));
        Thread computer = new Thread(cpu = new Computer(player2, ball, this));
        Thread player = new Thread(input = new Input(ui.getFrame(), this, player1));
        computer.start();
        player.start();
        
    }
    public void draw(Graphics2D g)
    {
    }
    public void redrawScreen()
    {
        Vector<Drawable> vec = new Vector<Drawable>();
        vec.add(player1);
        vec.add(player2);
        vec.add(ball);
        vec.add(this);
        ui.redrawList(vec);
    }
    public void update()
    {
        ball.move();
    }
    public void moveBall()
    {
        ball.move();
        if(checkPaddleHit())
        {
            ball.rewind();
            ball.reverseX();
        }
        if(checkBallWallHitHor()){
            ball.rewind();
            ball.reverseY();
        }else if(checkBallWallHitVer()){
            ball.rewind();
            ball.reverseX();
        }
    }
    public void moveUp(Block player)
    {
        player.moveUp();
        if(player.getY() < 0)
            player.moveDown();
    }
    public void moveDown(Block player)
    {
        player.moveDown();
        if(ySize < player.getY()+player.getH())
            player.moveUp();
    }
    public boolean checkBallWallHitHor()
    {
        return ball.getY() < 0 || ySize < ball.getY()+ball.getH();
    }
    public boolean checkBallWallHitVer()
    {
        return ball.getX() < 0 || xSize < ball.getX()+ball.getW();
    }
    public boolean checkPaddleHit()
    {
        return player1.getBoundary().intersects(ball.getBoundary()) || player2.getBoundary().intersects(ball.getBoundary());
    }
    public int getXSize()
    {
        return xSize;
    }
    public int getYSize()
    {
        return ySize;
    }
}
