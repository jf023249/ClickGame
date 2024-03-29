

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Add functions called by buttons




//__________________________________________________________________________________________________

public class ClickGame {

	public int money = 0;
	public boolean flag = false;
	int multiplier = 1;
	public boolean flag2 = false;
	public int fifteenCount = 0;
	public int fiveCount = 0;
	public int oneCount = 0;
	
	
	
	
	
	
	private static JFrame frame;
	private static JTextField textField;
	private static JTextArea textArea;
	private static JScrollBar sb;
	private static JTextArea textArea_2;
	private static JScrollBar sb_2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickGame window = new ClickGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public ClickGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon2 = new ImageIcon("dollar.jpeg");
		
		JButton btnAdd = new JButton(icon2);
		btnAdd.setBounds(17, 296, 330, 158);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOne add = new AddOne();
				add.start();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnAdd);
		
		JButton btnAddEvery = new JButton("1");
		btnAddEvery.setBounds(225, 0, 63, 39);
		btnAddEvery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOnePerSec persec = new AddOnePerSec();
				persec.start();
			}
		});
		
		JButton btnAdd5Every = new JButton("5");
		btnAdd5Every.setBounds(225, 51, 63, 39);
		btnAdd5Every.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFivePerSec fivepersec = new AddFivePerSec();
				fivepersec.start();
			}
		}); 
		
		JButton btnAdd15Every = new JButton("15");
		btnAdd15Every.setBounds(225, 102, 63, 39);
		btnAdd15Every.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFifteenPerSec fifteenpersec = new AddFifteenPerSec();
				fifteenpersec.start();
			}
		}); 
		
		
		
		frame.getContentPane().add(btnAddEvery);
		frame.getContentPane().add(btnAdd5Every);
		frame.getContentPane().add(btnAdd15Every);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 226, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 51, 190, 230);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(324, 37, 209, 243);
		frame.getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(558, 203, 303, 479);
		frame.getContentPane().add(scrollPane_1);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		
		JLabel lblNews = new JLabel("NEWS");
		lblNews.setBounds(682, 147, 190, 43);
		frame.getContentPane().add(lblNews);
		
		textArea_1.append("Prices: \n ------------ \n Ones: 50 \n Fives: 250 \n Fifteens: 3000 ");
		
		
		sb = scrollPane.getVerticalScrollBar();
		sb_2 = scrollPane_1.getVerticalScrollBar();
		
		
		Update update = new Update();
		RandomBoost random = new RandomBoost();
		RandomNews news = new RandomNews();
		news.start();
		random.start();
		update.start();
		
		flag = false;
		
			
		}
	
	class Update extends Thread{
		public void run() {
			int loop = 1;
			while(loop == 1)
			{
			textField.setText("Money: $" + String.valueOf(money));
			}
		}
	}
	
	class AddOne extends Thread{
		
		
		public void run() {
			try {
				money += multiplier;	
				sb.setValue( sb.getMaximum() );

			}
			catch(Exception e){
				System.out.println("The exceptions are: " + e);
			}
		}
	}

	class AddOnePerSec extends Thread{
		public boolean wait = false;
		public void run() {
			try {
					if((money-50) >=0)
					{
					money-=50;
					oneCount++;
					textArea.append("You now have " + oneCount + " ones. \n");
					sb.setValue( sb.getMaximum() );
					while(1==1)
					{
						money = money + multiplier;
						Thread.sleep(1000);
					}
					}
					else
					{
						textArea.append("Not enough money to buy that. \n");

					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	class AddFivePerSec extends Thread{
		public boolean wait = false;
		public void run() {
			try {
					if((money-250) >=0)
					{
					money-=250;
					fiveCount++;
					textArea.append("You now have " + fiveCount + " fives. \n");
					sb.setValue( sb.getMaximum() );
					while(1 == 1)
					{
						money = money + multiplier;
						Thread.sleep(200);
					}
					}
					else
					{
						textArea.append("Not enough money to buy that. \n");
					}
				
					
			}
			catch(Exception e){
				e.printStackTrace();
				}
		}
		
	}
	
	class AddFifteenPerSec extends Thread{
		public void run() {
			try {
				if((money-3000) >=0)
				{
				money-=3000;
				fifteenCount++;
				textArea.append("You now have " + fifteenCount + " fifteens. \n");
				sb.setValue( sb.getMaximum() );
				while(1==1)
				{
					money = money + multiplier;
					Thread.sleep(66);
				}
				}
				else
				{
					textArea.append("Not enough money to buy that. \n");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	class RandomBoost extends Thread{
		public void run() {
			System.out.println("random working");
			try {
				int loop = 1;
			while (loop == 1)
			{
		double random = Math.random();
		if(random <= .2) {
			multiplier = 15;
			textArea.append("Multiplier boost engaged!\n Click Click Click!!! \n");
			sb.setValue( sb.getMaximum() );
			Thread.sleep(10000);
			multiplier = 1;
			textArea.append("Boost over.");
		}
		else {
			Thread.sleep(30000);
		}
		}
		}
		catch(Exception e) {e.printStackTrace();}
	}
	}
	class RandomNews extends Thread{
		public void run() {
			try {
				while(1 == 1)
				{
				Thread.sleep(60000);
				double random = Math.random();
				if(random <=.1)
				{
					textArea_2.append("NEWS 1\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.2)
				{
					textArea_2.append("NEWS 2\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.3)
				{
					textArea_2.append("NEWS 3\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.4)
				{
					textArea_2.append("NEWS 4\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.5)
				{
					textArea_2.append("NEWS 5\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.6)
				{
					textArea_2.append("NEWS 6\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.7)
				{
					textArea_2.append("NEWS 7\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.8)
				{
					textArea_2.append("NEWS 8\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else if(random <=.9)
				{
					textArea_2.append("NEWS 9\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				else 
				{
					textArea_2.append("NEWS 10\n");
					sb_2.setValue( sb_2.getMaximum() );

				}
				}
			}
			catch(Exception e) {e.printStackTrace();}
		}
	}
}























