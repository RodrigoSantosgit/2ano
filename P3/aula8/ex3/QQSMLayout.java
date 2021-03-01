package aula8.ex3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class QQSMLayout {

	private JFrame window;
	private Container container;
	private JToggleButton[] helpButtons;
	private Container imageContainer;
	
	public QQSMLayout() {
		
		window = new JFrame("Quem Quer Ser Milionário");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		
		helpButtons = new JToggleButton[3];
		
		for(int i = 0; i< helpButtons.length; i++) {
			helpButtons[i] = new JToggleButton();
		}
		helpButtons[0].setText("50-50");
		helpButtons[1].setText("Telefone");
		helpButtons[2].setText("Ajuda Publico");
		
		imageContainer = new Container();
		imageContainer.setSize((1/4)*500, (1/4)*500);
		
		
		Container buttons = new Container();
		buttons.setBackground(Color.WHITE);
		buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttons.add(helpButtons[0]);
		buttons.add(helpButtons[1]);
		buttons.add(helpButtons[2]);
		
		container = window.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		container.add(imageContainer, BorderLayout.WEST);
		container.add(buttons, BorderLayout.WEST);
		container.setVisible(true);
		
		window.setVisible(true);
	}
}
