import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Time
{

	int timeCounter;
	public Time()
	{
		messageChangeLock = new ReentrantLock();
		divisible = messageChangeLock.newCondition();
		timeCounter = 0;
	}	

	private Lock messageChangeLock;
	private Condition divisible;

	public int increment(Time time)
	{
		time.messageChangeLock.lock();
		try
		{
			timeCounter++;
			divisible.signalAll();
			return timeCounter;
		}
		finally
		{
			time.messageChangeLock.unlock();
			System.out.print(timeCounter+ " ");
		}
	}
	public void checkCondition(Time time, int interval)
	{
		time.messageChangeLock.lock();
		try
		{
			while((time.timeCounter%interval) != 0)
				divisible.await();
			System.out.println(interval + "message");
		}
		catch(InterruptedException e)
		{
			System.out.println(" ");
		}
		finally
		{
			messageChangeLock.unlock();
		}
	}

}
