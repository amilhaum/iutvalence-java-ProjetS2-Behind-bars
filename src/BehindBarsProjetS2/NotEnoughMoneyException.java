package BehindBarsProjetS2;

public class NotEnoughMoneyException extends Exception
{
	public NotEnoughMoneyException(String message)
	{
		super(message);
	}

	public NotEnoughMoneyException(String message, Throwable t)
	{
		super(message, t);
	}
}
