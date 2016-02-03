import java.util.Timer;
import java.util.TimerTask;

public class Main2 
{

  public static void main(String[] args)
  {
    Time counter = new Time();
    TimePrinting timer = new TimePrinting(counter); 
    MessagePrinting message1 = new MessagePrinting(counter, 15);
    MessagePrinting message2 = new MessagePrinting(counter, 7);
  }
}
