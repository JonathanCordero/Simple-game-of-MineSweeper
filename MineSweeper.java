import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MineSweeper implements ActionListener{

	private JLabel rowLabel;
	private JLabel rowLabel2;
	private JLabel columnLabel;
	private JLabel columnLabel2;
	private JLabel bombLabel;
	private JButton start;
	private JButton start2;
	private JButton start3;
	private JButton custom;
	private JButton customPlus;
	private JButton back;
	private JButton back2;
	private JTextField columnField;
	private JTextField columnField2;
	private JTextField rowField;
	private JTextField rowField2;
	private JTextField bombField;
	private GridBagConstraints positionConst;
	
	private static JPanel homeContainer;
    private static CardLayout cl;

    private JPanel homePanel;
    private JPanel customPanel;
    private JPanel customPanelPlus;
    private JPanel MineSweeper;
    
    private JButton Interact[][];
    private boolean x=true;
    private boolean y[][];
    private JFrame ms;
    private int win;
    private int r =10;
    private int c =10;
    private int b =25;
    private boolean click[][];
	
	public MineSweeper() {
		
		ms = new JFrame("MineSweeper");
		
		ms.add(DeckOfCards());
	      cl.show(homeContainer, "Home");
	      ms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      ms.setLocationRelativeTo(null);
	      ms.setExtendedState(JFrame.MAXIMIZED_BOTH);
	      ms.pack();
	      ms.setVisible(true);
	}
	
	private JPanel DeckOfCards() {
		start = new JButton ("START");
		start2 = new JButton ("START");
		start3 = new JButton ("START");
		custom = new JButton ("CUSTOM");
		customPlus = new JButton("CUSTOM+");
		back = new JButton("BACK");
		back2 = new JButton("BACK");
		
		cl = new CardLayout();
        homeContainer = new JPanel(cl);
        homeContainer.setBackground(Color.black);
        
        homeContainer.add(Home(), "Home");
        homeContainer.add(Custom(), "Custom");
        homeContainer.add(Customplus(), "Custom+");
        
        start.addActionListener(this);
        start2.addActionListener(this);
        start3.addActionListener(this);
        custom.addActionListener(this);
        customPlus.addActionListener(this);
        back.addActionListener(this);
        back2.addActionListener(this);
        
	return homeContainer;
	}
	
	private JPanel Home() {
		homePanel = new JPanel();
		
		homePanel.setLayout(new GridBagLayout());
		homePanel.setBackground(Color.white);
		positionConst = new GridBagConstraints();
		positionConst.gridx = 0;
	    positionConst.gridy = 0;
		
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 0;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    homePanel.add(start, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 1;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    homePanel.add(custom, positionConst);
		
	    positionConst.gridx = 0;
	    positionConst.gridy = 2;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    homePanel.add(customPlus, positionConst);
	    
		return homePanel;
	}
	
	private JPanel Custom() {
		customPanel = new JPanel();
		customPanel.setBackground(Color.white);
		
		rowLabel2 = new JLabel("Number of rows:");
	    columnLabel2 = new JLabel("Number of columns:");
	    
	    rowField2 = new JTextField(15);
	      rowField2.setEditable(true);
	      rowField2.setText("10");

	      columnField2 = new JTextField(15);
	      columnField2.setEditable(true);
	      columnField2.setText("10");
		
		customPanel.setLayout(new GridBagLayout());
		customPanel.setBackground(Color.white);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 0;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(rowLabel2, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 0;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(rowField2, positionConst);
		
	    positionConst.gridx = 0;
	    positionConst.gridy = 1;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(columnLabel2, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 1;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(columnField2, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 2;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(start2, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 3;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanel.add(back, positionConst);
	    
		return customPanel;
	}
	
	private JPanel Customplus() {
		customPanelPlus = new JPanel();
		customPanelPlus.setBackground(Color.white);
		
		rowLabel = new JLabel("Number of rows:");
	    columnLabel = new JLabel("Number of columns:");
	    bombLabel = new JLabel("Number of bombs:");
	    
	    rowField = new JTextField(15);
	      rowField.setEditable(true);
	      rowField.setText("10");

	      columnField = new JTextField(15);
	      columnField.setEditable(true);
	      columnField.setText("10");
	      
	      bombField = new JTextField(15);
	      bombField.setEditable(true);
	      bombField.setText("25");
		
		customPanelPlus.setLayout(new GridBagLayout());
		customPanelPlus.setBackground(Color.white);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 0;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(rowLabel, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 0;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(rowField, positionConst);
		
	    positionConst.gridx = 0;
	    positionConst.gridy = 1;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(columnLabel, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 1;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(columnField, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 2;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(bombLabel, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 2;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(bombField, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 3;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(start3, positionConst);
	    
	    positionConst.gridx = 0;
	    positionConst.gridy = 4;
	    positionConst.insets = new Insets(10, 10, 10, 10);
	    customPanelPlus.add(back2, positionConst);
	    
		return customPanelPlus;
	}
	
	public JPanel Mine() {
		
		Grid minesweeper = new Grid();
		MineSweeper = new JPanel();
		int ph;
		String PH;
		
		MineSweeper.setLayout(new GridLayout(r,c));
		Interact = new JButton[r][c];
		y = new boolean [r][c];
		click = new boolean [r][c];
		for(int i = 0; i<r;i++) {
			for(int k = 0; k<c;k++) {
				final int finalA=i;
				final int finalB=k;
				if(minesweeper.isBombAtLocation(i, k)) {
					Interact[i][k] = new JButton(" ");
					Interact[i][k].setActionCommand("B");
					Interact[i][k].setBackground(Color.black);
					Interact[i][k].addActionListener(this);
					Interact[i][k].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if (SwingUtilities.isRightMouseButton(e)) {
								if(click[finalA][finalB]==true) {
									Interact[finalA][finalB].setBackground(Color.red);
									click[finalA][finalB]=false;
									
								}
								else if (click[finalA][finalB]==false){
									Interact[finalA][finalB].setBackground(Color.black);
									click[finalA][finalB]=true;
								}
								}
							}
						}
					);
					y[i][k] = false;
					click[i][k] = true;
					positionConst.gridx = i;
				    positionConst.gridy = k;
				    positionConst.insets = new Insets(10, 10, 10, 10);
				    MineSweeper.add(Interact[i][k], positionConst);
				}
				else {
					if(minesweeper.getCountAtLocation(i, k)==0) {
						Interact[i][k] = new JButton(" ");
						Interact[i][k].setActionCommand(" ");
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
					else {
						ph = minesweeper.getCountAtLocation(i, k);
						PH = Integer.toString(ph);
						Interact[i][k] = new JButton();
						switch(ph) {
						case 1: Interact[i][k].setForeground(Color.blue);
						break;
						case 2: Interact[i][k].setForeground(Color.pink);
						break;
						case 3: Interact[i][k].setForeground(Color.magenta);
						break;
						case 4: Interact[i][k].setForeground(Color.red);
						break;
						case 5: Interact[i][k].setForeground(Color.orange);
						break;
						case 6: Interact[i][k].setForeground(Color.magenta);
						break;
						case 7: Interact[i][k].setForeground(Color.pink);
						break;
						case 8: Interact[i][k].setForeground(Color.black);
						break;
						default: break;
						}
						Interact[i][k].setActionCommand(PH);
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
				}
			}
		}
		return MineSweeper;
	}
	
	public JPanel Mine(int r,int c) {
		
		Grid minesweeper = new Grid(r,c);
		MineSweeper = new JPanel();
		int ph;
		String PH;
		
		MineSweeper.setLayout(new GridLayout(r,c));
		Interact = new JButton[r][c];
		y = new boolean [r][c];
		click = new boolean [r][c];
		for(int i = 0; i<r;i++) {
			for(int k = 0; k<c;k++) {
				final int finalA=i;
				final int finalB=k;
				if(minesweeper.isBombAtLocation(i, k)) {
					Interact[i][k] = new JButton(" ");
					Interact[i][k].setActionCommand("B");
					Interact[i][k].setBackground(Color.black);
					Interact[i][k].addActionListener(this);
					Interact[i][k].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if (SwingUtilities.isRightMouseButton(e)) {
								if(click[finalA][finalB]==true) {
									Interact[finalA][finalB].setBackground(Color.red);
									click[finalA][finalB]=false;
									
								}
								else if (click[finalA][finalB]==false){
									Interact[finalA][finalB].setBackground(Color.black);
									click[finalA][finalB]=true;
								}
								}
							}
						}
					);
					
					y[i][k] = false;
					click[i][k] = true;
					
					positionConst.gridx = i;
				    positionConst.gridy = k;
				    positionConst.insets = new Insets(10, 10, 10, 10);
				    MineSweeper.add(Interact[i][k], positionConst);
				}
				else {
					if(minesweeper.getCountAtLocation(i, k)==0) {
						Interact[i][k] = new JButton(" ");
						Interact[i][k].setActionCommand(" ");
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
					else {
						ph = minesweeper.getCountAtLocation(i, k);
						PH = Integer.toString(ph);
						Interact[i][k] = new JButton();
						Interact[i][k].setActionCommand(PH);
						switch(ph) {
						case 1: Interact[i][k].setForeground(Color.blue);
						break;
						case 2: Interact[i][k].setForeground(Color.pink);
						break;
						case 3: Interact[i][k].setForeground(Color.magenta);
						break;
						case 4: Interact[i][k].setForeground(Color.red);
						break;
						case 5: Interact[i][k].setForeground(Color.orange);
						break;
						case 6: Interact[i][k].setForeground(Color.magenta);
						break;
						case 7: Interact[i][k].setForeground(Color.pink);
						break;
						case 8: Interact[i][k].setForeground(Color.black);
						break;
						default: break;
						}
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
				}
			}
		}
		return MineSweeper;
	}

	public JPanel Mine(int r,int c, int b) {
		
		Grid minesweeper = new Grid(r,c,b);
		MineSweeper = new JPanel();
		int ph;
		String PH;
		
		MineSweeper.setLayout(new GridLayout(r,c));
		Interact = new JButton[r][c];
		y = new boolean [r][c];
		click = new boolean [r][c];
		for(int i = 0; i<r;i++) {
			for(int k = 0; k<c;k++) {
				final int finalA=i;
				final int finalB=k;
				if(minesweeper.isBombAtLocation(i, k)) {
					Interact[i][k] = new JButton(" ");
					Interact[i][k].setActionCommand("B");
					Interact[i][k].setBackground(Color.black);
					Interact[i][k].addActionListener(this);
					Interact[i][k].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if (SwingUtilities.isRightMouseButton(e)) {
								if(click[finalA][finalB]==true) {
									Interact[finalA][finalB].setBackground(Color.red);
									click[finalA][finalB]=false;
									
								}
								else if (click[finalA][finalB]==false){
									Interact[finalA][finalB].setBackground(Color.black);
									click[finalA][finalB]=true;
								}
								}
							}
						}
					);
					
					y[i][k] = false;
					click[i][k] = true;
					
					positionConst.gridx = i;
				    positionConst.gridy = k;
				    positionConst.insets = new Insets(10, 10, 10, 10);
				    MineSweeper.add(Interact[i][k], positionConst);
				}
				else {
					if(minesweeper.getCountAtLocation(i, k)==0) {
						Interact[i][k] = new JButton(" ");
						Interact[i][k].setActionCommand(" ");
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
					else {
						ph = minesweeper.getCountAtLocation(i, k);
						PH = Integer.toString(ph);
						Interact[i][k] = new JButton();
						Interact[i][k].setActionCommand(PH);
						switch(ph) {
						case 1: Interact[i][k].setForeground(Color.blue);
						break;
						case 2: Interact[i][k].setForeground(Color.pink);
						break;
						case 3: Interact[i][k].setForeground(Color.magenta);
						break;
						case 4: Interact[i][k].setForeground(Color.red);
						break;
						case 5: Interact[i][k].setForeground(Color.orange);
						break;
						case 6: Interact[i][k].setForeground(Color.magenta);
						break;
						case 7: Interact[i][k].setForeground(Color.pink);
						break;
						case 8: Interact[i][k].setForeground(Color.black);
						break;
						default: break;
						}
						Interact[i][k].setBackground(Color.black);
						y[i][k] = false;
						click[i][k] = true;
						
						positionConst.gridx = i;
					    positionConst.gridy = k;
					    positionConst.insets = new Insets(10, 10, 10, 10);
					    MineSweeper.add(Interact[i][k], positionConst);
					    Interact[i][k].addActionListener(this);
					    Interact[i][k].addMouseListener(new MouseAdapter() {
					    	@Override
							public void mousePressed(MouseEvent e) {
								if (SwingUtilities.isRightMouseButton(e)) {
									if(click[finalA][finalB]==true) {
										Interact[finalA][finalB].setBackground(Color.red);
										click[finalA][finalB]=false;
										
									}
									else if (click[finalA][finalB]==false){
										Interact[finalA][finalB].setBackground(Color.black);
										click[finalA][finalB]=true;
									}
									}
								}
							}
						);
					}
				}
			}
		}
		return MineSweeper;
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(MineSweeper::new);
	}

	private void JOption() {
		if (win == 0){
			int option = JOptionPane.showConfirmDialog(ms, "You have won! Would you like to play again?", null, JOptionPane.YES_NO_OPTION);
			
			switch (option) {
	         case JOptionPane.YES_OPTION:
	        	homeContainer.add(Mine(r,c,b),"MineSweeper");
	 			cl.show(homeContainer, "MineSweeper");
	 			win=(r*c)-b;
	         break;
	         case JOptionPane.NO_OPTION:
	         ms.dispose();
	         break;
	         case JOptionPane.CLOSED_OPTION:
	         JOption();
	         break;
	      }
		}
		else {
		int option = JOptionPane.showConfirmDialog(ms, "You have lost. Would you like to play again?", null, JOptionPane.YES_NO_OPTION);
		
		switch (option) {
         case JOptionPane.YES_OPTION:
        	
        	homeContainer.add(Mine(r,c,b),"MineSweeper");
 			cl.show(homeContainer, "MineSweeper");
 			win=(r*c)-b;
         break;
         case JOptionPane.NO_OPTION:
         ms.dispose();
         break;
         case JOptionPane.CLOSED_OPTION:
         JOption();
         break;
		}
      }
	}
	
	private void flip(int i, int k) {
	   Interact[i][k].setText(Interact[i][k].getActionCommand());
 	   Interact[i][k].setBackground(Color.white);
 	   y[i][k]=true;
 	   x = false;
 	   win-=1;
	}
	
	private void neighbor(int i, int k) {
			try {
				if (Interact[i][k-1].getActionCommand().equalsIgnoreCase(" ")&& y[i][k-1]==false) {
					flip(i,k-1);
					neighbor(i,k-1);
				}
				else if (y[i][k-1]==false) {
					flip(i,k-1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i][k+1].getActionCommand().equalsIgnoreCase(" ")&& y[i][k+1]==false) {
					flip(i,k+1);
					neighbor(i,k+1);
				}
				else if (y[i][k+1]==false){
					flip(i,k+1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i-1][k].getActionCommand().equalsIgnoreCase(" ")&& y[i-1][k]==false) {
					flip(i-1,k);
					neighbor(i-1,k);
				}
				else if(y[i-1][k]==false) {
					flip(i-1,k);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i-1][k-1].getActionCommand().equalsIgnoreCase(" ")&& y[i-1][k-1]==false) {
					flip(i-1,k-1);
					neighbor(i-1,k-1);
				}
				else if( y[i-1][k-1]==false) {
					flip(i-1,k-1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i-1][k+1].getActionCommand().equalsIgnoreCase(" ")&& y[i-1][k+1]==false) {
					flip(i-1,k+1);
					neighbor(i-1,k+1);
				}
				else if(y[i-1][k+1]==false) {
					flip(i-1,k+1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i+1][k].getActionCommand().equalsIgnoreCase(" ")&& y[i+1][k]==false) {
					flip(i+1,k);
					neighbor(i+1,k);
				}
				else if(y[i+1][k]==false) {
					flip(i+1,k);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i+1][k-1].getActionCommand().equalsIgnoreCase(" ")&& y[i+1][k-1]==false) {
					flip(i+1,k-1);
					neighbor(i+1,k-1);
				}
				else if(y[i+1][k-1]==false) {
					flip(i+1,k-1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
			try {
				if (Interact[i+1][k+1].getActionCommand().equalsIgnoreCase(" ")&& y[i+1][k+1]==false) {
					flip(i+1,k+1);
					neighbor(i+1,k+1);
				}
				else if(y[i+1][k+1]==false) {
					flip(i+1,k+1);
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== start) {
			homeContainer.add(Mine(),"MineSweeper");
			cl.show(homeContainer, "MineSweeper");
			win=(r*c)-b;
		}
		else if (e.getSource()== start2) {
			String capture = rowField2.getText();
			r = Integer.parseInt(capture);
			capture = columnField2.getText();
			c = Integer.parseInt(capture);
			
			homeContainer.add(Mine(r,c),"MineSweeper2");
			cl.show(homeContainer, "MineSweeper2");
			win = (r*c)-b;
		}
		
		else if (e.getSource()==start3) {
			String capture = rowField.getText();
			r = Integer.parseInt(capture);
			capture = columnField.getText();
			c = Integer.parseInt(capture);
			capture = bombField.getText();
			b = Integer.parseInt(capture);
			homeContainer.add(Mine(r,c,b),"MineSweeper");
			cl.show(homeContainer, "MineSweeper");
			win=(r*c)-b;
		}
		
		else if (e.getSource() == custom) {
			cl.show(homeContainer, "Custom");
		}
		else if (e.getSource() == customPlus) {
			cl.show(homeContainer, "Custom+");
		}
		else if (e.getSource() == back) {
			cl.show(homeContainer, "Home");
		}
		else if (e.getSource() == back2) {
			cl.show(homeContainer, "Home");
		}
		
		else if (e.getActionCommand().equalsIgnoreCase("B")) {
			
			for (int i = 0; i < r; i++) {
				if (x==false) {
					break;
					}
			    for (int k = 0; k < c; k++) {
			       if (Interact[i][k] == e.getSource()) {
			    	   x = false;
			    	   final int a=i;
			    	   final int d=k;
			    	   if (click[a][d]==false) {
							return;
						}
			    	   break;
			       }
			    }
			}
			x = true;
			
			for (int i = 0; i < r; i++) {
	            for (int k = 0; k < c; k++) {
	                Interact[i][k].setText(Interact[i][k].getActionCommand());
	                Interact[i][k].setBackground(Color.white);
	            }
			}
			JOption();
		}
		
		else if (e.getActionCommand().equalsIgnoreCase(" ")) {
			for ( int i = 0; i < r; i++) {
				if (x==false) {
				break;
				}
				
			    for ( int k = 0; k < c; k++) {
			    	final int a = i;
			    	final int d = k;
			    	if (Interact[a][d] == e.getSource()&&y[a][d]==false && click[a][d]==true) {
			    	   flip(a,d);
			    	   neighbor(a,d);
			    	   break;
			       }
			       if(click[a][d]==false) {
			    	   return;
			       }
			    }
			}
			x=true;
			
			if (win<=0) {
				JOption();
			}
		}
		
		else {
			for (int i = 0; i < r; i++) {
				if (x==false) {
				break;
				}
			    for (int k = 0; k < c; k++) {
			    	final int a=i;
			    	final int d=k;
			    	if (Interact[a][d] == e.getSource() && y[a][d]==false && click[a][d]==true) {
			    	   
			    	   flip(a,d);
			    	   break;
			       }
			       if(click[a][d]==false) {
			    	   return;
			       }
			    }
			}
			x=true;	
			if (win<=0) {
				JOption();
			}
		}
	}

}
