package DragNDrop;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;



public class FenetreDragNDrop extends JFrame
{


		private JPanel contentPane= new ContenuFenetre();
		 
				 
		/**
		 * Launch the drag and drop window.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FenetreDragNDrop frame = new FenetreDragNDrop();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the window which contains the infirmary's objects.
		 */
		public FenetreDragNDrop() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(100, 100, 800, 600);
			
			this.setTitle("BehindBars");
			this.setSize(800, 600);
			
			this.setResizable(false);
			this.setAlwaysOnTop(true);
			this.setLocationRelativeTo(null);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel office = new JLabel("office");
			office.setForeground(Color.BLACK);
			office.setFont(new Font("Tahoma", Font.PLAIN, 11));
			office.setBackground(Color.DARK_GRAY);
			office.setBounds(140, 11, 255, 117);
			contentPane.add(office);
			
			JLabel sewers = new JLabel("sewers");
			sewers.setName("sewers");
			sewers.setBounds(187, 28, 43, 50);
			contentPane.add(sewers);
			
			JLabel bin = new JLabel("bin");
			bin.setBounds(10, 230, 73, 70);
			contentPane.add(bin);
			
			JLabel plant_1 = new JLabel("plant");
			plant_1.setBounds(10, 397, 73, 85);
			contentPane.add(plant_1);
			
			JLabel plant_2 = new JLabel("plant");
			plant_2.setBounds(188, 415, 73, 85);
			contentPane.add(plant_2);
			
			JLabel plant_3 = new JLabel("plant");
			plant_3.setBounds(484, 328, 73, 85);
			contentPane.add(plant_3);
			
				
		//pour ajouter un événement lorsque l'on clique sur 'sewers'
			
			/*sewers.addMouseListener(new MouseAdapter() {
            @Override
             public void mouseClicked(MouseEvent e) 
            {
            	System.out.println("congratulations! You've finished the game!");
    			
            }

            });*/

			 
		 }
		
		}	
		

