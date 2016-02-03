import java.util.*;

public class MessagePrinting implements Runnable
{
	Time timer = new Time();
	int interval;
	public MessagePrinting(Time time, int interv)
	{
		timer = time;
		interval = interv;
		new Thread(this).start();
	}

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				timer.checkCondition(timer, interval);
				Thread.sleep(1001);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}	
}
