package project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class B_UI implements ActionListener{

	JFrame frame = new JFrame("Checkers");
	JFrame frame2 = new JFrame("Checkers");
	JPanel panel = new JPanel(new GridLayout(8, 8), true);
	JPanel panel2= new JPanel();
	JLabel[][] grid2 = new JLabel[8][8];
	JButton[][] grid = new JButton[8][8];
	Boardspot[][] board=new Boardspot[8][8];
	ImageIcon r = new ImageIcon(getClass().getResource("images/red.gif"));
	ImageIcon g = new ImageIcon(getClass().getResource("images/gray.gif"));
	TextField[] fields=new TextField[4];
	JButton act=new JButton("Manipulate Screen");
	d_logic obj=new d_logic();
	
	public B_UI() {

		
		
		
		
		obj.fillboard();
		obj.printer();
		obj.establishLinks();
		this.board=obj.board;
	}
	
	public void setUpgrid() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.add(panel);
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(400, 300);
		act.addActionListener(this);
		frame2.setVisible(true);
		frame2.add(panel2);
		updateUI(board);
		frame2.pack();
	}

	public void setUplabels() {

		setUpRows();
		
		for(int i=0; i<fields.length; i++){
			fields[i]=new TextField("Enter Text");
			panel2.add(fields[i]);
		}
		panel2.add(act);
		
	}

	public void setUpRows() {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				grid[row][col] = new JButton();
				grid2[row][col] = new JLabel();

				if (row % 2 == col % 2) {
					if (row < 3) {
						grid[row][col].setBackground(Color.WHITE);
						grid[row][col].setIcon(g);

					} else if (row > 4) {
						grid2[row][col].setBackground(Color.WHITE);
						grid[row][col].setIcon(r);
					} //else
						//grid[row][col].setBackground(Color.RED);
				} else {
					grid[row][col].setBackground(Color.RED);
				}

				grid[row][col].setSize(150, 100);
				panel.add(grid[row][col]);

			}
		}

	}

	public void manipulateUI(String a, String b, String c, String d) {

	if(obj.userValidmove(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c), Integer.parseInt(d))==false)
		JOptionPane.showMessageDialog(null, "Invalid Move", "Error", JOptionPane.ERROR_MESSAGE);
	
	}
	
	public void updateUI(Boardspot[][] board){
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				
				if(board[row][col].getType().equalsIgnoreCase("red"))
					grid[row][col].setIcon(r);

				else if(board[row][col].getType().equalsIgnoreCase("white"))
					grid[row][col].setIcon(g);
				
				if(board[row][col].getType().equalsIgnoreCase("empty"))
					grid[row][col].setIcon(null);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==act){
			manipulateUI(fields[0].getText(),fields[1].getText(),fields[2].getText(),fields[3].getText());
			updateUI(board);
			obj.makeMove();
			updateUI(board);
			if(obj.isWin())
			JOptionPane.showMessageDialog(null, "WIN WIN WIN", "Error", JOptionPane.ERROR_MESSAGE);
		
		}
	}

}
