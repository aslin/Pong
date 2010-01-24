
import java.util.Observer;
import java.util.Observable;


public class GameEngine implements Runnable, Observer
{
    private UserInterface ui;
    private GamePad gamepad;
    private Thread t = new Thread(this);
    
    public GameEngine()
    {
        ui = new UserInterface("Pong Deluxe", 500, 500, GSettings.getColor("black"));
        ui.setVisible(true);
        gamepad = new GamePad(ui);
        t.start();
    }
    public void run()
    {   
        long currTime = System.currentTimeMillis();
        long lastTime = currTime;     
        int cnt = 0;
        
        while(true){
            currTime = System.currentTimeMillis();
            if(currTime - lastTime > 30){
                lastTime = currTime;
                gamepad.moveBall();
                gamepad.redrawScreen();
            }
            try{
                Thread.yield();
            }catch(Exception ex){}
        }
    }
    public void update(Observable obs, Object obj)
    {
    }
}

