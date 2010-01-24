
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Input extends KeyboardInput implements Runnable 
{
    private GamePad gamepad;
    private Block player1;
    //private Block player2;
    
    public Input(JFrame frame, GamePad gamepad, Block player1)
    {
        super(frame);
        this.gamepad = gamepad;
        this.player1 = player1;
        //this.player2 = player2;
    }
    public void run()
    {
        while(true){
            poll();
            if(keyDown(KeyEvent.VK_UP))
                gamepad.moveUp(player1);
            if(keyDown(KeyEvent.VK_DOWN))
                gamepad.moveDown(player1);
            if(keyDown(KeyEvent.VK_W))
                gamepad.moveUp(player1);
            if(keyDown(KeyEvent.VK_S))
                gamepad.moveDown(player1);
            try{
                Thread.sleep(10);
            }catch(Exception ex){}
        }
    }
}
