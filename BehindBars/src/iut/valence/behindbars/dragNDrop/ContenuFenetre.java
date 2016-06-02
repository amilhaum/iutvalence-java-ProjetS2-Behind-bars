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

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ContenuFenetre extends JPanel {
		 
	private Image img;
	private ImageIcon fond;
			
	public ContenuFenetre(String name)
	{
		super();

		this.fond = new ImageIcon(getClass().getResource("/pictures/" + name + ".jpg"));
		this.img = this.fond.getImage();
		setLayout(null); 
		 
        ComponentMove listener = new ComponentMove(this);
	        
        addMouseListener(listener);
        addMouseMotionListener(listener);
     }
	
		
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = g;

		g2.drawImage(this.img, 0, -15, null);
	}

			private static class ComponentMove extends MouseAdapter 
		    {

		        private boolean move;
		        private int x1;
		        private JComponent component;
		        private int y1;
		        private Container container;
		 
		        public ComponentMove(Container container) 
		        {
		            this.container=container;
		        }
		 
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
		        
		      
		 
		        @Override
		        public void mouseMoved(MouseEvent e) 
		        {
		        	
					if ( move ) 
					{
		                
		                component.setLocation(e.getX()-x1, e.getY()-y1);
		            }
		        
		        
		        
		        
		        /*ContenuFenetre pan = new ContenuFenetre("infirmaryBackground2");
				
				
			
				JLabel bed1 = new JLabel("");
				bed1.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed1.setBounds(51, 153, 49, 92);
				pan.add(bed1);

				JLabel bed2 = new JLabel("");
				bed2.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed2.setBounds(51, 303, 49, 99);
				pan.add(bed2);

				JLabel bed3 = new JLabel("");
				bed3.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed3.setBounds(207, 448, 49, 99);
				pan.add(bed3);

				JLabel bed4 = new JLabel("");
				bed4.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed4.setBounds(350, 448, 49, 99);
				pan.add(bed4);

				JLabel bed5 = new JLabel("");
				bed5.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed5.setBounds(643, 448, 49, 99);
				pan.add(bed5);

				JLabel bed6 = new JLabel("");
				bed6.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed6.setBounds(207, 11, 49, 92);
				pan.add(bed6);

				JLabel bed7 = new JLabel("");
				bed7.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/bed.jpg")));
				bed7.setBounds(207, 153, 49, 92);
				pan.add(bed7);

				JLabel trapdoor = new JLabel("trapdoor");
				trapdoor.setIcon(new ImageIcon(FenetreDragNDrop.class.getResource("/pictures/trapdoor.png")));
				trapdoor.setName("sewers");
				trapdoor.setBounds(350, 491, 39, 25);
				pan.add(trapdoor);*/

				// pour ajouter un evenement lorsque l'on clique sur 'trapdoor'

				
		        
		 
		    }
		    	
}}
