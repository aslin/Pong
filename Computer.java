
public class Computer implements Runnable
{
    private Block block;
    private Ball ball;
    private GamePad gamepad;
    
    public Computer(Block block, Ball ball, GamePad gamepad)
    {
        this.block = block;
        this.ball = ball;
        this.gamepad = gamepad;
    }
    public void run()
    {
        int tY;   
        while(true){
            if(ball.getDx() < 0){
                 tY = (gamepad.getYSize()/2)-(block.getH()/2);
            }else{
                int x = ball.getX();
                int y = ball.getY();
                int dx = ball.getDx();
                int dy = ball.getDy();
                double k  = dy/dx;
                tY = (int)(k*470-k*x+y);
                if(tY < 0)
                    tY = -tY;
                else if(gamepad.getYSize()+block.getH() < tY)
                    tY = gamepad.getYSize()-(tY-gamepad.getYSize());
                    
                
            }
            if(block.getY() < tY-3)
                gamepad.moveDown(block);
            else if(block.getY() > tY+3)
                gamepad.moveUp(block);  
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
    }
}
