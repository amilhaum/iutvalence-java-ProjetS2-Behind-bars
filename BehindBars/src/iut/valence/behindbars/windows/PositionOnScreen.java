package iut.valence.behindbars.windows;
/**
 * The position on screen.
 * 
 * @author BehindBars
 * @version 1.0.0
 */
public class PositionOnScreen
{
	/** The line's number of the position. */
	private int	x;
	/** The column's number of the position. */
	private int	y;

	/**
	 * The constructor of the position.
	 * 
	 * @param x0 the line's number of the position.
	 * @param y0 the column's number of the position.
	 */
	public PositionOnScreen(int x0, int y0)
	{
		this.x = x0;
		this.y = y0;
	}

	/**
	 * The getter of the line's number.
	 * 
	 * @return line's number
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * The getter of the column's number.
	 * 
	 * @return column's number
	 */

	public int getY()
	{
		return y;
	}


}
