package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Windows extends JFrame implements ActionListener
{
	public static Room	room[];
	private JButton		right_button;
	private JButton		left_button;
	private JButton		bottom_button;
	private JButton		top_button;

	public Windows()
	{
		/* Default windows */
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		;
		this.setLocationRelativeTo(null);

		initButton();
		initRoom();

		this.setContentPane(room[0]);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object sourceClick = e.getSource();
		Object sourceRoom = this.getContentPane();
		if (sourceRoom == this.room[0])
		{
			setARoom(1);
		}

		else if (sourceRoom == this.room[1])
		{
			if (sourceClick == this.left_button)
			{
				setARoom(0);
			}
			else if (sourceClick == this.right_button)
			{
				setARoom(2);
			}
			else
			{
				setARoom(4);
			}
		}

		else if (sourceRoom == this.room[2])
		{
			setARoom(1);
		}

		else if (sourceRoom == this.room[4])
		{
			if (sourceClick == this.top_button)
				setARoom(1);
			else
				setARoom(3);
		}

		else
			setARoom(4);
	}

	private void initRoom()
	{
		this.room = new Room[]
		{
				new Room("cell"), new Room("corridor"), new Room("outside"), new Room("corridor"), new Room("breakroom")
		};

		room[0].setLayout(null);
		room[1].setLayout(null);
		room[2].setLayout(null);
		room[3].setLayout(null);
		room[4].setLayout(null);

		room[0].add(this.right_button);

	}

	public void initButton()
	{
		this.right_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_east.png")));
		this.right_button.setBounds(745, 270, 45, 30);
		this.right_button.addActionListener(this);

		this.left_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_west.png")));
		this.left_button.setBounds(5, 270, 45, 30);
		this.left_button.addActionListener(this);

		this.bottom_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_south.png")));
		this.bottom_button.setBounds(385, 520, 30, 45);
		this.bottom_button.addActionListener(this);

		this.top_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_north.png")));
		this.top_button.setBounds(385, 5, 30, 45);
		this.top_button.addActionListener(this);
	}

	public void setARoom(int x)
	{

		this.setContentPane(room[x]);
		this.repaint();
		this.revalidate();

		if (x == 0)
		{
			room[0].add(right_button);
		}

		else if (x == 1)
		{
			room[1].add(this.left_button);
			room[1].add(this.bottom_button);
			room[1].add(this.right_button);
		}

		else if (x == 2)
		{
			room[2].add(this.left_button);
		}

		else if (x == 3)
		{
			room[3].add(this.top_button);
		}

		else if (x == 4)
		{
			room[4].add(this.bottom_button);
			room[4].add(this.top_button);
		}
	}
}
