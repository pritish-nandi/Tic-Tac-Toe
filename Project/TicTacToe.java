import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JPanel button = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean p1Turn;

	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);

		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 800, 100);

		button.setLayout(new GridLayout(3,3));
		button.setBackground(new Color(150, 150, 150));

		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
			button.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		title.add(textField);
		frame.add(title, BorderLayout.NORTH);
		frame.add(button);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < buttons.length; i++){
        	if(e.getSource()==buttons[i]){

        		if(p1Turn){
        			if(buttons[i].getText()==""){
        				buttons[i].setForeground(new Color(255, 0, 0));
        				buttons[i].setText("X");
        				p1Turn = false;
        				textField.setText("Player 2's turn");
        				check();
			        }
		        }else{
			        if(buttons[i].getText()==""){
				        buttons[i].setForeground(new Color(0, 0, 255));
				        buttons[i].setText("O");
				        p1Turn = true;
				        textField.setText("Player 1's turn");
				        check();
			        }
		        }

	        }
        }
	}

	public void firstTurn(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

        if(random.nextInt(2)==0){
        	p1Turn = true;
        	textField.setText("Player 1's turn");
        }else{
	        p1Turn = false;
	        textField.setText("Player 2's turn");
        }
	}

	public void check(){
        // check p1 wins conditions
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
			p1Wins(0, 1, 2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
			p1Wins(3, 4, 5);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
			p1Wins(6, 7, 8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
			p1Wins(0, 3, 6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
			p1Wins(1, 4, 7);
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
			p1Wins(2, 5, 8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
			p1Wins(0, 4, 8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
			p1Wins(2, 4, 6);
		}

		// check p2 wins conditions
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
			p2Wins(0, 1, 2);
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
			p2Wins(3, 4, 5);
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
			p2Wins(6, 7, 8);
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
			p2Wins(0, 3, 6);
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
			p2Wins(1, 4, 7);
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
			p2Wins(2, 5, 8);
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
			p2Wins(0, 4, 8);
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
			p2Wins(2, 4, 6);
		}
	}

	public void p1Wins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < buttons.length; i++){
        	buttons[i].setEnabled(false);
        }
        textField.setText("Player 1 wins");
	}

	public void p2Wins(int a, int b, int c){
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for(int i = 0; i < buttons.length; i++){
			buttons[i].setEnabled(false);
		}
		textField.setText("Player 2 wins");
	}

}
