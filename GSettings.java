import java.awt.Color;
public class GSettings
{
    public static final Color getColor(String colorString)
    {
        Color color;
        if(colorString.equals("red")) {
            color = Color.red;
        }
        else if(colorString.equals("black")) {
            color = Color.black;
        }
        else if(colorString.equals("blue")) {
            color = Color.blue;
        }
        else if(colorString.equals("yellow")) {
            color = Color.yellow;
        }
        else if(colorString.equals("green")) {
            color = Color.green;
        }
        else if(colorString.equals("magenta")) {
            color = Color.magenta;
        }
        else if(colorString.equals("white")) {
            color = Color.white;
        }
        else if(colorString.equals("orange")) {
            color = Color.orange;
        }
        else if(colorString.equals("cyan")) {
            color = Color.cyan;
        }
        else if(colorString.equals("pink")) {
            color = Color.pink;
        }
        else {
            color = Color.black;
        }
        return color;
    }
}
