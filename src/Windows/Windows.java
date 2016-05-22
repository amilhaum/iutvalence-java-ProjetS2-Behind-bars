package Windows;

import javax.swing.JFrame;

public class Windows extends JFrame
{
	public static Room room;

	public Windows()
	{
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		;
		this.setLocationRelativeTo(null);

		room = new Room();

		this.setContentPane(room);
		this.setVisible(true);
	}

}
