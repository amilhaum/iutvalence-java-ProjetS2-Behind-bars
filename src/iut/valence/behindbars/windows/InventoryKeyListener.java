package iut.valence.behindbars.windows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import iut.valence.behindbars.windows.MainWindows;
/**
 * KeyListener to catch "i" key (Inventory)
 * 
 * @author admin
 *
 */
public class InventoryKeyListener implements KeyListener {
	/**
	 * List of item's picture.
	 * @TODO Load the variable with each item's picture, not with a sample!
	 */
	private static final String[] imgUrlList = {"/pictures/blue.jpg"};
	/**
	 * Empty inventory slot picture
	 */
	private static final String EmptySlotImgUrl = "/pictures/red.jpg";
	/**
	 * Is the inventory open?
	 */
	private static boolean isInventaryOpen = false;
	/**
	 * List of loaded images as Icon
	 */
	private ImageIcon[] imgIconList;
	/**
	 * Initialize the KeyListener
	 */
	public InventoryKeyListener() {
		super();
		
		this.imgIconList = new ImageIcon[10];
	}
	/**
	 * When the 'i' key is pressed, open the inventory
	 * @TODO link each item to a MouseListener to catch a click on it
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char key = e.getKeyChar();
		
		if (key == 'i' && !isInventaryOpen) {
			isInventaryOpen = true;
			URL rUrl;
		    BufferedImage img = null;
		    
		    for(int i = 0; i < imgUrlList.length; i++) {
				try {
		            rUrl = getClass().getResource(imgUrlList[i]);
		            if (rUrl != null) {
		                img = ImageIO.read(rUrl);
		            }
		        } catch (IOException ex) {
		            System.err.println("MEC T'AS TOUT FUCKED UP !!!");
		            ex.printStackTrace();
		        }
				imgIconList[i] = new ImageIcon(img);
		    }
		    
			try {
	            rUrl = getClass().getResource(EmptySlotImgUrl);
	            if (rUrl != null) {
	                img = ImageIO.read(rUrl);
	            }
	        } catch (IOException ex) {
	            System.err.println("MEC T'AS TOUT FUCKED UP !!!");
	            ex.printStackTrace();
	        }

		    for(int i = imgUrlList.length; i < 10; i++) {
				imgIconList[i] = new ImageIcon(img);
		    }
		    
		    for(int i = 0; i < 10; i++) {
				MainWindows.jlabelList[i].setIcon(imgIconList[i]);
		    }
		}
	}
	/**
	 * When the 'i' key is closed, close the inventory
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		char key = e.getKeyChar();
		
		if (key == 'i' && isInventaryOpen) {
			isInventaryOpen = false;
		    for(int i = 0; i < 10; i++) {
				MainWindows.jlabelList[i].setIcon(null);
		    }
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
