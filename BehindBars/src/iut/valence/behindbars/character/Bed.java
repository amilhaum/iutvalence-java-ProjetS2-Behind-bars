package iut.valence.behindbars.character;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import iut.valence.behindbars.windows.PositionOnScreen;

import javax.swing.ImageIcon;
/* Initializing the object Bed*/
public class Bed {

	
	protected String name;

	protected PositionOnScreen pos;
	
	/* Constructor of the Bed, with his parameters
	 * 
	 * @param a name, and the position of the object on the screen
	 * */
	public Bed(String name, PositionOnScreen pos0)
	{
		this.name = name;
		this.pos = pos0;
	}
	/*Reading accessor for the name*/
	public String getName() {
		return name;
	}
	/*Reading accessor for the position*/
	public PositionOnScreen getPos() {
		return pos;
	}

	

}
