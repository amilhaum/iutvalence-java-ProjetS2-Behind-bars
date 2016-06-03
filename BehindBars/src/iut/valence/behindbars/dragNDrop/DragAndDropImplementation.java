package iut.valence.behindbars.dragNDrop;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import javax.swing.JPanel;


/**
 * The Class that implements the Drag and Drop
 * 
 * @author montcare
 *
 */
public class DragAndDropImplementation extends JPanel {

	/** The serial version ID. */
	private static final long serialVersionUID = -267058525892016700L;

	/**
	 * an image
	 */
	private Image img;

	/**
	 * a background image
	 */
	private ImageIcon fond;

	/**
	 * The DragAndDropImplementation constructor
	 * 
	 * @param name is the name associated to the background image
	 */
	public DragAndDropImplementation(String name)
	{
		super();

		this.fond = new ImageIcon(getClass().getResource("/pictures/" + name + ".jpg"));
		this.img = this.fond.getImage();
		setLayout(null); 

		ComponentMove listener = new ComponentMove(this);

		addMouseListener(listener);
		addMouseMotionListener(listener);
	}


	/**
	 * method that draws the background image on the window
	 */
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = g;

		g2.drawImage(this.img, 0, -15, null);
	}

	
	/**
	 * Class to apply events on mouse actions
	 * @author montcare
	 *
	 */
	private static class ComponentMove extends MouseAdapter 
	{

		/**
		 * the component movement state 
		 */
		private boolean move;
		
		/**
		 * x coordinate
		 */
		private int x1;
		/**
		 * y coordinate
		 */
		private int y1;
		
		/**
		 * a component 
		 */
		private JComponent component;
		
		/**
		 * a container
		 */
		private Container container;

		
		/**
		 * The ComponentMove constructor 
		 * 
		 * @param container contains the components
		 */
		public ComponentMove(Container container) 
		{
			this.container=container;
		}

		
		/**
		 * method which handles the case where the mouse is pressed
		 */
		@Override
		public void mousePressed(MouseEvent e) 
		{
			if ( move ) 
			{
				move=false; 
				component.setBorder(null);
				component=null;
			}
			else 
			{
				component = getComponent(e.getX(),e.getY()); 
				if ( component!=null && component.getName()!= "trapdoor") 
				{
					container.setComponentZOrder(component,0); 

					x1 = e.getX()-component.getX(); 
					y1 = e.getY()-component.getY(); 
					move=true; 
					component.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

				}
			}
		}


		/**
		 * method to get JComponent component 
		 * 
		 * @param x is the coordinate on the horizontal axe
		 * @param y is the coordinate on the vertical
		 * 
		 * @return a component of JComponent type 
		 */
		private JComponent getComponent(int x, int y) 
		{  

			for(Component component : container.getComponents()) 
			{
				if ( component instanceof JComponent && component.getBounds().contains(x, y) ) 
				{
					return (JComponent)component;
				}
			}
			return null;
		}



		/**
		 * method which handles the case where the mouse is in movement
		 */
		@Override
		public void mouseMoved(MouseEvent e) 
		{

			if ( move ) 
			{

				component.setLocation(e.getX()-x1, e.getY()-y1);
			}

		}

	}
	
}
