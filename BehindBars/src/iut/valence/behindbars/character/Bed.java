package iut.valence.behindbars.character;

import iut.valence.behindbars.windows.PositionOnScreen;

import javax.swing.ImageIcon;

public class Bed {

	
	protected String name;

	protected PositionOnScreen pos;
	
	public Bed(String name, PositionOnScreen pos0)
	{
		this.name = name;
		this.pos = pos0;
	}

	public String getName() {
		return name;
	}

	public PositionOnScreen getPos() {
		return pos;
	}

	

}
