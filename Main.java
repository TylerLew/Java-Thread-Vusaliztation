import java.awt.*;
import javax.swing.*;
public class Main extends JFrame {
	
	final int width = 50;
	final int height = 50;
	int id2;
	public Main(int phase, int winner) {
		final Grid grid;
		 Grid grid2;
		if(phase==1)
		{
			grid = new Grid(width, height);
			Walkers walk1 = new Walkers(grid,0,0,0);
			Walkers walk2 = new Walkers(grid,1,9,9);
			Walkers walk3 = new Walkers(grid,2,9,0);
			Walkers walk4 = new Walkers(grid,3,0,9);
			  
			setTitle("Phase 1");
			setSize(515, 535);
			setLayout(new BorderLayout());
			add(grid, BorderLayout.CENTER);
			setVisible(true);
				    
				  
			walk3.start();
			walk2.start();
			walk1.start();
			walk4.start(); 
		}
		else if(phase == 2)
		{
			
			grid2 = new Grid(width, height);
			System.out.println("Time for Phase 2");
			setTitle("Phase 2");
			setSize(515, 535);
			setLayout(new BorderLayout());
			add(grid2, BorderLayout.CENTER);
			setVisible(true);
			grid2.drawGrid();
			Walkers walkwin = new Walkers(grid2,winner,0,0);
			walkwin.start();
		}
		
		
		
}
	   


public static void main(String[] args) 
	{
		new Main(1,-1);
	}
}