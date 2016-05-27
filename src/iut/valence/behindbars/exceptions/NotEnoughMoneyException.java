package iut.valence.behindbars.exceptions;

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
