package aula8;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class LayoutJogo implements ActionListener {

	static JToggleButton[] buttons = new JToggleButton[9];
	private PlayersJogo jogo = new PlayersJogo();
	
	public LayoutJogo(){
		drawLayout();
	}
	
	private void drawLayout() {
		JFrame window = new JFrame("Jogo Do Galo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
		
		
		JPanel content = (JPanel)window.getContentPane();
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(3,3));
		
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setLayout(new FlowLayout());
		
		
		for(int i = 0 ; i< buttons.length; i++) {
			buttons[i] = new JToggleButton();
			buttons[i].setFont(new Font("Arial", Font.BOLD, 70));
			buttons[i].addActionListener(this);
			content.add(buttons[i]);
		}
		window.setContentPane(content);
		window.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JToggleButton button = (JToggleButton) event.getSource();
		button.setEnabled(false);
		
		if(button == buttons[0])
			jogo.turnPlay(1, 1);
		else if(button == buttons[1])
			jogo.turnPlay(1, 2);
		else if(button == buttons[2])
			jogo.turnPlay(1, 3);
		else if(button == buttons[3])
			jogo.turnPlay(2, 1);
		else if(button == buttons[4])
			jogo.turnPlay(2, 2);
		else if(button == buttons[5])
			jogo.turnPlay(2, 3);
		else if(button == buttons[6])
			jogo.turnPlay(3, 1);
		else if(button == buttons[7])
			jogo.turnPlay(3, 2);
		else if(button == buttons[8])
			jogo.turnPlay(3, 3);

		button.setText(jogo.lastPlayer());
		
		if(jogo.finished()) {
			if(jogo.lastPlayerWinner()) {
				JOptionPane.showMessageDialog(null,jogo.lastPlayer() + "ganhou!");
			}else {
				JOptionPane.showMessageDialog(null,"Empate!");
			}
			System.exit(0);
		}
	}
}
