import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class GameOfLifeFrame extends JFrame 
{



	public static final int GRID_R = 100;
	public static final int GRID_C = 100;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Still lifes\nOscillators\nRandom\n\n");
		
		int[][] gridValueCurrent = new int[GRID_R][GRID_C];
		String selection = "";
		Scanner input = new Scanner(System.in);
		selection = input.nextLine();

		int sleep = 150;
		
		//startGrid 0s
		for(int r = 0; r < GRID_R; r++)
		{
			for(int c = 0; c < GRID_C; c++)
			{
					gridValueCurrent[r][c] = 0; 
			}
		}
		
		
		//starting values
		if (selection.compareTo("Still lifes") == 0)
		{
			// Block
			gridValueCurrent[50][25-10] = 1;
			gridValueCurrent[50][26-10] = 1;
			gridValueCurrent[50+1][25-10] = 1;
			gridValueCurrent[50+1][26-10] = 1;
			
			// Bee-hive
			gridValueCurrent[50-1][49-15] = 1;
			gridValueCurrent[50-1][49+1-15] = 1;
			gridValueCurrent[50][49-1-15] = 1;
			gridValueCurrent[50][49+2-15] = 1;
			gridValueCurrent[50+1][49-15] = 1;
			gridValueCurrent[50+1][49+1-15] = 1;
			
			// Loaf
			gridValueCurrent[50-1][49] = 1;
			gridValueCurrent[50-1][49+1] = 1;
			gridValueCurrent[50][49-1] = 1;
			gridValueCurrent[50][49+2] = 1;
			gridValueCurrent[50+1][49] = 1;
			gridValueCurrent[50+1][49+2] = 1;
			gridValueCurrent[50+2][49+1] = 1;
			
			// Boat
			gridValueCurrent[50-1][49+10-1+5] = 1;
			gridValueCurrent[50-1][49+10+5] = 1;
			gridValueCurrent[50][49+10-1+5] = 1;
			gridValueCurrent[50][49+10+1+5] = 1;
			gridValueCurrent[50+1][49+10+5] = 1;
			
			// Tub
			gridValueCurrent[50-1][49+15+15] = 1;
			gridValueCurrent[50][49+15+1+15] = 1;
			gridValueCurrent[50][49+15-1+15] = 1;
			gridValueCurrent[50+1][49+15+15] = 1;

			sleep = 750;
		}
		else if(selection.compareTo("Oscillators") == 0)
		{
			// Blinker
			gridValueCurrent[50][25-10] = 1;
			gridValueCurrent[50][26-10] = 1;
			gridValueCurrent[50][27-10] = 1;
			
			// Toad
			gridValueCurrent[50][49-15] = 1;
			gridValueCurrent[50][49-16] = 1;
			gridValueCurrent[50][49-17] = 1;
			gridValueCurrent[51][49-14] = 1;
			gridValueCurrent[51][49-15] = 1;
			gridValueCurrent[51][49-16] = 1;
			
			// Beacon
			gridValueCurrent[50][49] = 1;
			gridValueCurrent[50][50] = 1;
			gridValueCurrent[50+1][49] = 1;
			gridValueCurrent[50+1][50] = 1;
			
			gridValueCurrent[50+2][49+2] = 1;
			gridValueCurrent[50+2][50+2] = 1;
			gridValueCurrent[50+1+2][49+2] = 1;
			gridValueCurrent[50+1+2][50+2] = 1;
			
			
			// Penta-decathlon
			gridValueCurrent[50-3][70-1] = 1;
			gridValueCurrent[50-3][70+1] = 1;
			gridValueCurrent[50-3][70] = 1;
			gridValueCurrent[50-2][70-1] = 1;
			gridValueCurrent[50-2][70+1] = 1;
			gridValueCurrent[50-1][70-1] = 1;
			gridValueCurrent[50-1][70+1] = 1;
			gridValueCurrent[50-1][70] = 1;
			gridValueCurrent[50][70-1] = 1;
			gridValueCurrent[50][70+1] = 1;
			gridValueCurrent[50][70] = 1;
			gridValueCurrent[50+1][70+1] = 1;
			gridValueCurrent[50+1][70-1] = 1;
			gridValueCurrent[50+1][70] = 1;
			gridValueCurrent[50+2][70+1] = 1;
			gridValueCurrent[50+2][70-1] = 1;
			gridValueCurrent[50+2][70] = 1;
			gridValueCurrent[50+3][70+1] = 1;
			gridValueCurrent[50+3][70-1] = 1;
			gridValueCurrent[50+4][70+1] = 1;
			gridValueCurrent[50+4][70-1] = 1;
			gridValueCurrent[50+4][70] = 1;


			sleep = 750;
			
		}
		else
		// Random
			for(int r = 0; r < GRID_R; r++)
			{
				for(int c = 0; c < GRID_C; c++)
				{
						if(Math.random() > .90)
							gridValueCurrent[r][c] = 1; 
				}
			}
			
		System.out.println(selection);
		   JFrame f = new JFrame("Game Of Life");
		   
		   f.setSize(1018, 1040);
		   f.setLocation(1300, 150);
		   
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   f.getContentPane().setLayout(null);
		   
		   
		   
		   int x = 0;
		   int y = 0; 
		   
		   JButton[][] buttonArray = new JButton[GRID_R][GRID_C];
		   for(int r = 0; r < GRID_R; r++)
		   {
			   for(int c = 0; c < GRID_C; c++)
			   {
				   buttonArray[r][c] = new JButton("");
				   buttonArray[r][c].setEnabled(false);
				   if(gridValueCurrent[r][c] == 0)
					   buttonArray[r][c].setBackground(Color.WHITE);
				   else
					   buttonArray[r][c].setBackground(Color.GREEN);
				   buttonArray[r][c].setBounds(x,y,10,10);
				   f.getContentPane().add(buttonArray[r][c]);
				   
				   
				   
				   x = x+10;				  
			   }
			   
			   x=0;
			   y=y+10;
		   }
		   
		   
		   f.setVisible(true);
		   while(1==1)
		   {
			   Thread.sleep(sleep);
			   int [][]futureGrid = calculateFutureGrid(gridValueCurrent);
			   updateFrame(buttonArray, futureGrid);
			   gridValueCurrent = futureGrid;
		   }
		   
	}	
	
	// Pass in frame and future values, and update 
	public static void updateFrame(JButton[][] buttonArray, int[][] grid) 
	{
		 for(int r = 0; r < GRID_R; r++)
		   {
			   for(int c = 0; c < GRID_C; c++)
			   {
				   if(grid[r][c] == 1)
					   buttonArray[r][c].setBackground(Color.GREEN);
				   else if(grid[r][c] == 2)
					   buttonArray[r][c].setBackground(Color.BLUE);
				   else
					   buttonArray[r][c].setBackground(Color.WHITE);

			   }

		   }
	}
	
	
	public static int[][] calculateFutureGrid(int[][] gridValueCurrent)
	{
		int[][] gridValueFuture = new int[GRID_R][GRID_C];
		for(int r = 0; r < GRID_R; r++)
		{
			for(int c = 0; c < GRID_C; c++)
			{
				if(r==0 && c == 0)
					gridValueFuture[r][c] = TLcornerCheck(gridValueCurrent);
				
				else if(r == GRID_R-1 && c == 0)
					gridValueFuture[r][c] = BLcornerCheck(gridValueCurrent);
				
				else if(r == GRID_R-1 && c == GRID_C-1)
					gridValueFuture[r][c] = BRcornerCheck(gridValueCurrent);
				
				else if(r == 0 && c == GRID_C-1)
					gridValueFuture[r][c] = TRcornerCheck(gridValueCurrent);
				
				else if(r == 0)
					gridValueFuture[r][c] = TwallCheck(gridValueCurrent, r, c);
				
				else if(c == 0)
					gridValueFuture[r][c] = LwallCheck(gridValueCurrent, r, c);
				
				else if(r == GRID_R-1)
					gridValueFuture[r][c] = BwallCheck(gridValueCurrent, r, c);
				
				else if(c == GRID_C-1)
					gridValueFuture[r][c] = RwallCheck(gridValueCurrent, r, c);
				
				else
					gridValueFuture[r][c] = regularCheck(gridValueCurrent, r, c);
			}
		}
		
		
		return gridValueFuture;
		
	}
	// Checks for corners
	
	public static int TLcornerCheck(int[][] grid)
	{
		int count = 0;
		int startingState = grid[0][0];
		
		if(grid[0][1] > 0 )
			count++;
		if(grid[1][1] > 0)
			count++;
		if(grid[1][0] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	public static int TRcornerCheck(int[][] grid)
	{
		int count = 0;
		int startingState = grid[0][GRID_R-1];
		
		if(grid[0][GRID_C-2] > 0)
			count++;
		if(grid[1][GRID_C-1] > 0)
			count++;
		if(grid[1][GRID_C-2] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	public static int BLcornerCheck(int[][] grid)
	{
		int count = 0;
		int startingState = grid[GRID_R-1][0];
		
		if(grid[GRID_R-2][0] > 0)
			count++;
		if(grid[GRID_R-2][1] > 0)
			count++;
		if(grid[GRID_R-1][1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	public static int BRcornerCheck(int[][] grid)
	{
		int count = 0;
		int startingState = grid[GRID_R-1][GRID_C-1];
		
		if(grid[GRID_R-2][GRID_C-2] > 0)
			count++;
		if(grid[GRID_R-1][GRID_C-2] > 0)
			count++;
		if(grid[GRID_R-2][GRID_C-1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	
	// Checks for walls
	public static int TwallCheck(int[][] grid, int r, int c)
	{
		int count = 0;
		int startingState = grid[r][c];
		
		
		if(grid[r][c-1] > 0)
			count++;
		if(grid[r][c+1] > 0)
			count++;
		if(grid[r+1][c-1] > 0)
			count++;
		if(grid[r+1][c] > 0)
			count++;
		if(grid[r+1][c+1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	public static int BwallCheck(int[][] grid, int r, int c)
	{
		int count = 0;
		int startingState = grid[r][c];
		
		
		if(grid[r][c+1] > 0)
			count++;
		if(grid[r][c-1] > 0)
			count++;
		if(grid[r-1][c] > 0)
			count++;
		if(grid[r-1][c+1] > 0)
			count++;
		if(grid[r-1][c-1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}	
	
	public static int LwallCheck(int[][] grid, int r, int c)
	{
		int count = 0;
		int startingState = grid[r][c];
		
		
		if(grid[r+1][c] > 0)
			count++;
		if(grid[r-1][c] > 0)
			count++;
		if(grid[r][c+1] > 0)
			count++;
		if(grid[r+1][c+1] > 0)
			count++;
		if(grid[r-1][c+1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
	public static int RwallCheck(int[][] grid, int r, int c)
	{
		int count = 0;
		int startingState = grid[r][c];
			
		
		if(grid[r+1][c] > 0)
			count++;
		if(grid[r-1][c] > 0)
			count++;
		if(grid[r][c-1] > 0)
			count++;
		if(grid[r+1][c-1] > 0)
			count++;
		if(grid[r-1][c-1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	

	
	public static int regularCheck(int[][] grid, int r, int c)
	{
		int count = 0;
		int startingState = grid[r][c];
		
		
		if(grid[r+1][c+1] > 0)
			count++;
		if(grid[r+1][c] > 0)
			count++;
		if(grid[r+1][c-1] > 0)
			count++;
		if(grid[r-1][c+1] > 0)
			count++;
		if(grid[r-1][c-1] > 0)
			count++;
		if(grid[r-1][c] > 0)
			count++;
		if(grid[r][c+1] > 0)
			count++;
		if(grid[r][c-1] > 0)
			count++;
		if(startingState == 0 && count == 3)
			return 1;
		if(startingState > 0 && (count == 2 || count == 3))
			return 2;
		return 0;
	}
	
}