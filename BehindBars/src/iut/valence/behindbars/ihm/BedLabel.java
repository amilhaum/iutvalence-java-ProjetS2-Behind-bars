package iut.valence.behindbars.ihm;

import iut.valence.behindbars.character.Bed;
import iut.valence.behindbars.dragNDrop.FenetreDragNDrop;
import iut.valence.behindbars.windows.PositionOnScreen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BedLabel extends JLabel{

	private String name;
	private PositionOnScreen pos;
	
	public BedLabel(Bed bed)
	{
		super(bed.getName());
		this.pos = bed.getPos();
		this.setIcon(new ImageIcon(getClass().getResource("/pictures/bed.jpg")));	
		this.setBounds(this.pos.getX(), this.pos.getY(), 49, 99);
	}

	public String getName() {
		return name;
	}

	public PositionOnScreen getPos() {
		return pos;
	}
}
