package iut.valence.behindbars.ihm;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import iut.valence.behindbars.dragNDrop.DragAndDropImplementation;
import iut.valence.behindbars.game.Room;

/**
 * IHM to display the room
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class IHM_Room extends JPanel
{
	/** The serial version ID. */
	private static final long serialVersionUID = -4122624538561520990L;
	/** The background of the room. */
	private ImageIcon	icoFond;
	/** The pictures of the room. */
	private Image		imgFond1;

	/**
	 * The constructor of the room's ihm.
	 * @param room is the room which is going to be shown
	 */
	public IHM_Room(Room room)
	{
		super();

		this.icoFond = room.getPicture();
		this.imgFond1 = this.icoFond.getImage();
		
		 if(room.getName() == "infirmary") 
		 {
			 new DragAndDropImplementation("infirmaryBackground2");
		 }
	}

	/** The method to paint the component. */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = g;

		g2.drawImage(this.imgFond1, 0, -15, null);
	}

}
