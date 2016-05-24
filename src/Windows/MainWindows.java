package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindows extends JFrame implements ActionListener
{
	private Map<String, JButton>	listOfButtons;
	private Room					room;

	public MainWindows()
	{
		/* Default windows */
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);

		this.room = new Room("maintest");
		this.listOfButtons = new HashMap<>();

		initButton();
		room.setLayout(null);
		room.add(this.listOfButtons.get("NewGame"));
		room.add(this.listOfButtons.get("QuitGame"));
		this.setContentPane(room);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	public void initButton()
	{
		this.listOfButtons.put("NewGame", new GameButtons(100, 450, 215, 49, new ImageIcon(getClass().getResource("/pictures/newgame.png"))));
		this.listOfButtons.put("QuitGame", new GameButtons(500, 450, 215, 49, new ImageIcon(getClass().getResource("/pictures/quitgame.png"))));

		for (Map.Entry<String, JButton> entry : this.listOfButtons.entrySet())
		{
			entry.getValue().addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object sourceClick = e.getSource();
		if (sourceClick == this.listOfButtons.get("NewGame"))
		{
			Windows win = new Windows();
			this.setContentPane(win.getContentPane());
			this.repaint();
			this.revalidate();
		}

		else
		{
			System.exit(0);
		}

	}
}