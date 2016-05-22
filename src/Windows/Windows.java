package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Windows extends JFrame implements ActionListener
{
	public static Room	room;
	private JButton		right_button;
	private JButton		left_button;
	private JButton		bottom_button;
	private JButton		top_button;

	public Windows(String name)
	{
		/* Default windows */
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		;
		this.setLocationRelativeTo(null);

		room = new Room(name);
		room.setLayout(null);

		switch (name)
		{
		case ("cell"):
			/* Right button */
			this.right_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_east.png")));
			this.right_button.setBounds(745, 270, 45, 30);
			this.right_button.addActionListener(this);

			room.add(right_button);

			break;

		case ("outside"):
			/* left button */
			this.left_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_west.png")));
			this.left_button.setBounds(5, 270, 45, 30);
			this.left_button.addActionListener(this);

			room.add(left_button);

			break;

		case ("breakroom"):
			/* left button */
			this.left_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_west.png")));
			this.left_button.setBounds(5, 270, 45, 30);
			this.left_button.addActionListener(this);

			/* top button */
			this.top_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_north.png")));
			this.top_button.setBounds(745, 270, 30, 45);
			this.top_button.addActionListener(this);

			/* bottom button */
			this.bottom_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_south.png")));
			this.bottom_button.setBounds(745, 270, 30, 45);
			this.bottom_button.addActionListener(this);

			room.add(top_button);
			room.add(left_button);
			room.add(bottom_button);

			break;

		case ("corridor"):
			/* left button */
			this.left_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_west.png")));
			this.left_button.setBounds(5, 270, 45, 30);
			this.left_button.addActionListener(this);

			/* right button */
			this.right_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_east.png")));
			this.right_button.setBounds(745, 270, 45, 30);
			this.right_button.addActionListener(this);

			/* bottom button */
			this.bottom_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_south.png")));
			this.bottom_button.setBounds(385, 520, 30, 45);
			this.bottom_button.addActionListener(this);

			room.add(right_button);
			room.add(left_button);
			room.add(bottom_button);

			break;

		case ("infirmary"):
			/* top button */
			this.top_button = new JButton(new ImageIcon(getClass().getResource("/pictures/arrow_north.png")));
			this.top_button.setBounds(745, 270, 30, 45);
			this.top_button.addActionListener(this);

			room.add(top_button);

			break;
		}

		this.setContentPane(room);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}
