package hello;

import java.util.Queue;
import java.util.LinkedList;

public class FifoQueue
{

	private Queue<String> queue = new LinkedList<String>();

	public void put( String s )
	{
		queue.add(s);
	}

	public String pop ()
	{
		return queue.remove();
	}

}