package snake_game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

//import java.util.Timer;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener,ActionListener {//এখানে extend দিয়ে অনেক মেথড ইউস করার জন্য ক্লাসটাকে তৈরী করা হয়েছে।
	 																		//
	private int[] snakexlength = new int[750]; //snake এর পজিশন এর জন্য
	private int[] snakeylength =new int[750];
	
	
	private boolean left = false;
	private boolean right = false;// দিকের জন্য এই ভ্যারিয়েবল গুলা
	private boolean up= false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;// এই গুলা হল ইমেজ।
	private ImageIcon leftmouth;
	
	private int lengthofsnake = 3;
	
	private int moves=0;
	
	private  Timer timer;
	private int delay =100;
	
	private ImageIcon snakeImage;
	
	private ImageIcon titleImage;//এটাই হল মেইন GUI
	
	public Gameplay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}

	 
	 public void paint(Graphics g) {
		
		 if(moves==0) {
			 snakexlength[2]=50;
			 snakexlength[1]=75;
			 snakexlength[0]=100;
			 
			 snakeylength[2]=100;
			 snakeylength[1]=100;
			 snakeylength[0]=100;
		 }
		 
		 //এখানে টাইটেল ইমেজের বর্ডার আকা হবে।
		 g.setColor(Color.white);
		 g.drawRect(24, 10, 851, 55);
		 
		 // title image আকব এখন।
		 titleImage =new ImageIcon("Snaketitle.jpg");
		 titleImage.paintIcon(this, g, 25, 11);
		 
		 
		 // gameplay এর বর্ডার
		 g.setColor(Color.WHITE);
		 g.drawRect(24, 74, 851, 577);
		 
		 
		 //backgroud for gameplay
		 g.setColor(Color.cyan);
		 g.fillRect(25, 75, 850, 575 ); ;//ইম

		 
		 
		 rightmouth =new ImageIcon("rightmouth.png");
		 rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);//snake positions
		 
		 
		 
		for(int a=0;a<lengthofsnake;a++) {
			 if(a==0 && right) {
				 rightmouth =new ImageIcon("rightmouth.png");
				 rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			 }
			 
			 if(a==0 && left) {
				 leftmouth =new ImageIcon("leftmouth.png");
				 leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			 }
			 
			 if(a==0 && down) {
				 downmouth =new ImageIcon("downmouth.png");
				 downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			 }
			 
			 if(a==0 && up) {
				 upmouth =new ImageIcon("upmouth.png");
				 upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			 }
			 
			 if(a!=0) {
				
				 snakeImage =new ImageIcon("snakeimage.png");
				 snakeImage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			 }
		 }
		 
		 
		
		 g.dispose();
	 
	 } 

//this is the movement section
	@Override
	public void actionPerformed(ActionEvent e) {		//actionlistener
		// TODO Auto-generated method stub
		timer.start();
		if(right) 
		{
			for (int r = lengthofsnake-1; r >= 0; r--) {
				snakeylength[r+1]=snakeylength[r];
			}
			
			for(int r=lengthofsnake; r>=0;r++) {
				if (r==0) {
					snakexlength[r]=snakexlength[r]+25;
					
				}
				else {
					snakexlength[r]=snakexlength[r-1];
				}
				
				if(snakexlength[r]>850)
				{
					snakexlength[r]=25; 
				}
			}
			
			
			repaint();//will call the method "paint" on line 54
			
		}
		if(left) 
		{
			for (int r = lengthofsnake-1; r >= 0; r--) {
				snakeylength[r+1]=snakeylength[r];
			}
			
			for(int r=lengthofsnake; r>=0;r++) {
				if (r==0) {
					snakexlength[r]=snakexlength[r]-25;
					
				}
				else {
					snakexlength[r]=snakexlength[r-1];
				}
				
				if(snakexlength[r]<850)
				{
					snakexlength[r]=850; 
				}
			}
			
			
			repaint();//will call the method "paint" on line 54
		}
		if(up) 
		{
			for (int r = lengthofsnake-1; r >= 0; r--) {
				snakexlength[r+1]=snakexlength[r];
			}
			
			for(int r=lengthofsnake; r>=0;r++) {
				if (r==0) {
					snakeylength[r]=snakeylength[r]-25;
					
				}
				else {
					snakeylength[r]=snakeylength[r-1];
				}
				
				if(snakeylength[r]<75)
				{
					snakeylength[r]=625; 
				}
			}
			
			
			repaint();//will call the method "paint" on line 54
		}
		if(down) 
		{
			for (int r = lengthofsnake-1; r >= 0; r--) {
				snakexlength[r+1]=snakexlength[r];
			}
			
			for(int r=lengthofsnake; r>=0;r++) {
				if (r==0) {
					snakeylength[r]=snakeylength[r]+25;
					
				}
				else {
					snakeylength[r]=snakeylength[r-1];
				}
				
				if(snakeylength[r]>625)
				{
					snakeylength[r]=75; 
				}
			}
			
			
			repaint();//will call the method "paint" on line 54
		}
		
		
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {				//rest of all are keyevent
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
			moves++;
			 right = true;
			 if (!left) {
				right=true;
			}
			 else {
				 right= false;
				 left= true;
			 }
			 
			 up= false;
			 down = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			
			moves++;
			 left = true;
			 if (!right) {
				right=true;
			}
			 else {
				left = false;
				right = true;
			 }
			 
			 up= false;
			 down = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			moves++;
			 up = true;
			 if (!down) {
				up=true;
			}
			 else {
				 up= false;
				 down= true;
			 }
			 
			 left= false;
			 right = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			
			moves++;
			 down = true;
			 if (!up) {
				down=true;
			}
			 else {
				 down= false;
				 up= true;
			 }
			 
			 left= false;
			 right = false;
		}
		

		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	