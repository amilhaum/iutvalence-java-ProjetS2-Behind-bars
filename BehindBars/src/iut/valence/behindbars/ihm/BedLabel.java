package iut.valence.behindbars.ihm;

import iut.valence.behindbars.character.Bed;
import iut.valence.behindbars.windows.PositionOnScreen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The bed's IHM.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class BedLabel extends JLabel{

	/** The serial version ID. */
	private static final long serialVersionUID = 7271257361854464059L;
	/** The name of bed's ihm. */
	private String name;
	/** The position of bed's ihm. */
	private PositionOnScreen pos;
	
	/**
	 * The construcor of bed's IHM.
	 * @param bed is the bed which is going to be shown
	 */
	public BedLabel(Bed bed)
	{
		super(bed.getName());
		this.pos = bed.getPos();
		this.setIcon(new ImageIcon(getClass().getResource("/pictures/bed.jpg")));	
		this.setBounds(this.pos.getX(), this.pos.getY(), 49, 99);
	}

	/**
	 * The name's getter
	 *
	 * @return the bed's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The position's getter
	 *
	 * @return the bed's position
	 */
	public PositionOnScreen getPos() {
		return pos;
	}
}
