import java.util.*;

public class TimePrinting implements Runnable
{
	private Time counter;
	public TimePrinting( Time t)
	{
		counter = t;
		new Thread(this).start();
	}

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				counter.increment(counter);
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	
}
