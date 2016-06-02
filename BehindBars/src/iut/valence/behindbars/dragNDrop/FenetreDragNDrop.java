package iut.valence.behindbars.dragNDrop;

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

		

	}
}
