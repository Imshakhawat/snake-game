package snake_game;

import javax.swing.JFrame;
import java.awt.Color;
public class NO1 {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay= new Gameplay();
		obj.setBounds(10,10,905,700);
		obj.setBackground(Color.black);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
		
		
		
		
		
		
		
		
		
	}

}
