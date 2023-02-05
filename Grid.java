//https://youtu.be/bMXnZE4_t94   2x speed and skip around the video its 48mins I apologize! 

import java.util.Random;

public class Grid {
	private boolean bombGrid [ ][ ];
	private int countGrid [][];
	private int numRows;
	private int numColumns;
	private int numBombs;
	private Random random = new Random();

	public Grid (){
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		this.countGrid = new int[10][10];
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.countGrid = new int [numRows][numColumns];
		this.numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int numRows, int numColumns, int numBombs) {
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.countGrid = new int [numRows][numColumns];
		this.numBombs = numBombs;
		createBombGrid();
		createCountGrid();
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	
	public int getNumBombs() {
		return numBombs;
	}
	
	public boolean [][] getBombGrid(){
		boolean copy [][] = new boolean [bombGrid.length][];
		for(int i = 0; i < bombGrid.length; i++) {
		    copy[i] = bombGrid[i].clone();
		}
		return copy;
	}
	
	public int [][] getCountGrid(){
		int copy[][] = new int[countGrid.length][];
		for(int i = 0; i < countGrid.length; i++) {
		    copy[i] = countGrid[i].clone();
		}
		return copy;
	}

	public boolean isBombAtLocation(int row, int column) {
		return bombGrid[row][column];
	}
	public int getCountAtLocation(int row, int column) {
		return countGrid[row][column];
	}

	private void createBombGrid() {
		this.bombGrid = new boolean [numRows][numColumns];
		int counter = numBombs;
		Random bomb = new Random();
		
		for (int i=0;i<numRows;i++) {
			for (int k=0; k<numColumns;k++) {
				bombGrid[i][k] = false;
			}
		}
		
		while (counter > 0){
			int r = bomb.nextInt(numRows);
			int c = bomb.nextInt(numColumns);
			if(bombGrid[r][c]==false) {
				bombGrid[r][c]=true;
				counter-=1;
			}
		}
	}
	
	private void createCountGrid(){
		this.countGrid = new int [numRows][numColumns];
		boolean radar;
		int count = 0;
		for (int i=0;i<numRows;i++) {
			for (int k=0; k<numColumns;k++) {
				radar = bombGrid[i][k];
				if (radar) {
					count += 1;
				}
				try {
					radar = bombGrid[i][k-1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i][k+1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i-1][k];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i-1][k-1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i-1][k+1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i+1][k];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i+1][k-1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				try {
					radar = bombGrid[i+1][k+1];
					if (radar) {
						count += 1;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
				}
				countGrid[i][k] = count;
				count = 0;
			}
		}
	}

	public boolean getState() {
		return random.nextBoolean();
	}
}
