package DragNDrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContenuFenetre extends JPanel {
		 
		JLabel p1;
		JLabel p2;
		JLabel p3;
		JLabel p4;
		
		
		   
			public ContenuFenetre() {
		 
		    	
		        setLayout(null); 
		 
		        ComponentMove listener = new ComponentMove(this);
  		        
		        addMouseListener(listener);
		        addMouseMotionListener(listener);
		        
		 
		    }   
		   
			
			
		   /* private static JComponent createComponent(ImageIcon i, int x,int y) {
		        
		    	
		    	JLabel component=new JLabel(); 
		       
		        component.setSize(125,125); 
		        
		        
		        component.setIcon(i);
		        
		        component.setLocation(x, y);
		        component.remove(component);
		        return component;
		    }*/
		 
		    private static class ComponentMove extends MouseAdapter 
		    {
		 
		    	
		    	
	            
		        private boolean move;
		        private int x1;
		        private JComponent component;
		        private int y1;
		        private Container container;
		 
		        public ComponentMove(Container container) {
		            this.container=container;
		        }
		 
		        @Override
		        public void mousePressed(MouseEvent e) {
		            if ( move ) {
		                move=false; 
		                component.setBorder(null);
		                component=null;
		            }
		            else {
		                component = getComponent(e.getX(),e.getY()); 
		                if ( component!=null && component.getName()!= "sewers") {
		                    container.setComponentZOrder(component,0); 
		                    
		                    x1 = e.getX()-component.getX(); 
		                    y1 = e.getY()-component.getY(); 
		                    move=true; 
		                    component.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
		                    
		                }
		            }
		        }
		 
		        private JComponent getComponent(int x, int y) {
		            
		            for(Component component : container.getComponents()) {
		                if ( component instanceof JComponent && component.getBounds().contains(x, y) ) {
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
		        }
		 
		    }
		    
		    
		 
		
			    

		
		


	
	
}
