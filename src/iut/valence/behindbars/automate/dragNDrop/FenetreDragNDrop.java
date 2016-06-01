package iut.valence.behindbars.automate.dragNDrop;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FenetreDragNDrop extends JFrame
{

	private JPanel contentPane = new ContenuFenetre();

	/**
	 * Launch the drag and drop window.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					FenetreDragNDrop frame = new FenetreDragNDrop();
					frame.setVisible(true);

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the window which contains the infirmary's objects.
	 */
	public FenetreDragNDrop()
	{

		/*
		 * setLayout(new BorderLayout()); JLabel background=new JLabel(new ImageIcon(getClass().getResource("/infirmaryBackground.jpg"))); add(background); background.setLayout(new FlowLayout());
		 */

		ContenuFenetre pan = new ContenuFenetre("infirmaryBackground2");
		setAlwaysOnTop(true);
		setResizable(false);
		this.setContentPane(pan);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.repaint();
		this.revalidate();

		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		pan.setToolTipText("");
		// contentPane.img = Toolkit.getDefaultToolkit().getImage(FenetreDragNDrop.class.getResource("/pictures/infimary.jpg"));
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		// setContentPane(new ImageIcon(getClass().getResource("/infirmary.jpg")));
		pan.setLayout(null);

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
		pan.add(trapdoor);

		// pour ajouter un événement lorsque l'on clique sur 'trapdoor'

		trapdoor.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("congratulations! You've finished the game!");

			}

		});

	}
}
